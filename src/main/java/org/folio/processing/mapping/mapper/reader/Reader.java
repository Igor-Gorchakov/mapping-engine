package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.model.context.EventContext;

public interface Reader {

    String read(EventContext eventContext);
}
