package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.mapper.writer.factory.WriterFactoryRegistry;
import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.reader.factory.ReaderFactoryRegistry;
import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.context.Rule;

import java.util.List;
import java.util.Map;

public class Mapper {
    private final ReaderFactoryRegistry readerFactoryRegistry;
    private final WriterFactoryRegistry writerFactoryRegistry;

    public Mapper(ReaderFactoryRegistry readerFactoryRegistry, WriterFactoryRegistry writerFactoryRegistry) {
        this.readerFactoryRegistry = readerFactoryRegistry;
        this.writerFactoryRegistry = writerFactoryRegistry;
    }

    public EventContext map(EventContext eventContext) {
        MappingProfile mappingProfile = eventContext.getMappingProfile();
        Map<String, Object> eventContextObjects = eventContext.getObjects();
        Reader reader = readerFactoryRegistry.createReader(mappingProfile.getIncomingRecordType());
        reader.initialize(eventContext);
        Writer writer = writerFactoryRegistry.createWriter(mappingProfile.getExistingRecordType());
        writer.initialize(eventContext);
        List<Rule> mappingRules = mappingProfile.getMappingRules();
        for (Rule rule : mappingRules) {
            Value value = reader.read(rule);
            writer.write(rule.getFieldName(), value);
        }
        writer.end(eventContext);
        return eventContext;
    }
}
