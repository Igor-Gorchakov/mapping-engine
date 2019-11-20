package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.model.context.EventContext;

public interface Writer {

    void write(String field, Value value);

    EventContext end(EventContext eventContext);
}
