package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.mapper.value.StringContainer;
import org.folio.processing.mapping.mapper.value.ValueContainer;
import org.folio.processing.mapping.model.schemas.MarcBibliographicRecord;

public class MarcBibliographicReader implements Reader {

    private MarcBibliographicRecord marcBibliographicRecord;

    public MarcBibliographicReader(MarcBibliographicRecord marcBibliographicRecord) {
        this.marcBibliographicRecord = marcBibliographicRecord;
    }

    @Override
    public ValueContainer read(String rule) {
        return new StringContainer("stub title");
    }
}
