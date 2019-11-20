package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.mapper.value.StringValue;
import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.model.schemas.MarcBibliographicRecord;

public class MarcBibliographicReader implements Reader {

    private MarcBibliographicRecord marcBibliographicRecord;

    public MarcBibliographicReader(MarcBibliographicRecord marcBibliographicRecord) {
        this.marcBibliographicRecord = marcBibliographicRecord;
    }

    @Override
    public Value read(java.lang.String rule) {
        return new StringValue("stub title");
    }
}
