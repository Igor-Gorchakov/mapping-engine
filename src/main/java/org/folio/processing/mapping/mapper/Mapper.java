package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.reader.ReaderFactory;
import org.folio.processing.mapping.mapper.value.ValueContainer;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.mapper.writer.WriterFactory;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Mapper {
    private final ReaderFactory readerFactory;
    private final WriterFactory writerFactory;

    public Mapper(ReaderFactory readerFactory, WriterFactory writerFactory) {
        this.readerFactory = readerFactory;
        this.writerFactory = writerFactory;
    }

    public EventContext map(EventContext eventContext) throws IOException {
        MappingProfile mappingProfile = eventContext.getMappingProfile();
        Map<String, Object> eventContextObjects = eventContext.getObjects();
        Reader reader = readerFactory.build(mappingProfile.getIncomingRecordType(), eventContextObjects);
        Writer writer = writerFactory.build(mappingProfile.getExistingRecordType(), eventContextObjects);
        List<String> mappingRules = mappingProfile.getMappingRules();
        for (String rule : mappingRules) {
            ValueContainer value = reader.read(rule);
            writer.write(rule, value);
        }
        return writer.end(eventContext);
    }
}
