package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.model.context.EventContext;

import java.io.IOException;

public interface Writer {

    EventContext write(String entity, EventContext eventContext) throws IOException;
}
