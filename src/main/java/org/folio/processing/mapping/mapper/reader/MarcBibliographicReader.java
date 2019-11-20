package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.mapper.value.StringValue;
import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.Rule;
import org.folio.processing.mapping.model.schemas.MarcBibliographicRecord;

public class MarcBibliographicReader implements Reader {

    private MarcBibliographicRecord marcBibliographicRecord;

    public MarcBibliographicReader() {
    }

    @Override
    public Value read(Rule rule) {
        return new StringValue("stub index title");
    }

    @Override
    public void initialize(EventContext eventContext) {

    }
}
