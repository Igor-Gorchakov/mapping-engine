package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.model.context.EventContext;

import java.io.IOException;

public class Mapper {
    private Reader reader;
    private Writer writer;

    public Mapper(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public EventContext map(EventContext eventContext) throws IOException {
        String entity = reader.read(eventContext);
        writer.write(entity, eventContext);
        return eventContext;
    }
}
