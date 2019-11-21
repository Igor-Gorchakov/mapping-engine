package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.context.Rule;

import java.io.IOException;
import java.util.List;

public class Mapper {
    private final Reader reader;
    private final Writer writer;

    public Mapper(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public EventContext map(EventContext eventContext) throws IOException {
        MappingProfile mappingProfile = eventContext.getMappingProfile();
        reader.initialize(eventContext);
        writer.initialize(eventContext);
        List<Rule> mappingRules = mappingProfile.getMappingRules();
        for (Rule rule : mappingRules) {
            Value value = reader.read(rule);
            writer.write(rule.getFieldPath(), value);
        }
        writer.end(eventContext);
        return eventContext;
    }
}
