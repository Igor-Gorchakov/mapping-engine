package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.reader.ReaderFactory;
import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.mapper.writer.WriterFactory;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.context.Rule;

import java.util.List;
import java.util.Map;

public class Mapper {
    private final ReaderFactory readerFactory;
    private final WriterFactory writerFactory;

    public Mapper(ReaderFactory readerFactory, WriterFactory writerFactory) {
        this.readerFactory = readerFactory;
        this.writerFactory = writerFactory;
    }

    public EventContext map(EventContext eventContext) {
        MappingProfile mappingProfile = eventContext.getMappingProfile();
        Map<String, Object> eventContextObjects = eventContext.getObjects();
        Reader reader = readerFactory.build(mappingProfile.getIncomingRecordType(), eventContextObjects);
        Writer writer = writerFactory.build(mappingProfile.getExistingRecordType(), eventContextObjects);
        List<Rule> mappingRules = mappingProfile.getMappingRules();
        for (Rule rule : mappingRules) {
            Value value = reader.read(rule);
            writer.write(rule.getFieldName(), value);
        }
        return writer.end(eventContext);
    }
}
