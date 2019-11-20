package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.context.Rule;
import org.folio.processing.mapping.model.schemas.MarcBibliographicRecord;
import org.folio.processing.mapping.mapper.value.StringValue;
import org.folio.processing.mapping.mapper.value.Value;

public class MarcBibliographicReader implements Reader {

    private MarcBibliographicRecord marcBibliographicRecord;

    public MarcBibliographicReader(MarcBibliographicRecord marcBibliographicRecord) {
        this.marcBibliographicRecord = marcBibliographicRecord;
    }

    @Override
    public Value read(Rule rule) {
        return new StringValue("stub index title");
    }

    @Override
    public MappingProfile.EntityType getEntityType() {
        return MappingProfile.EntityType.MARC_BIBLIOGRAPHIC;
    }


}
