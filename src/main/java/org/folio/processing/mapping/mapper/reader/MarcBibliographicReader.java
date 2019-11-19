package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.model.context.EventContext;

public class MarcBibliographicReader implements Reader {
    @Override
    public String read(EventContext eventContext) {
        return eventContext.getObjects().get("marcBibliographicRecord");
    }
}
