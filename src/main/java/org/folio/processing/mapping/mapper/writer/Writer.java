package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.mapper.value.ValueContainer;
import org.folio.processing.mapping.model.context.EventContext;

public interface Writer {

    void write(String rule, ValueContainer value);

    EventContext end(EventContext eventContext);
}
