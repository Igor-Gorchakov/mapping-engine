package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.Instance;
import org.folio.processing.mapping.model.MarcRecord;

import java.util.List;

import static org.folio.processing.mapping.model.MappingProfile.TargetType.INSTANCE;
import static org.folio.processing.mapping.model.MappingProfile.SourceType.MARC_BIBLIOGRAPHIC;

public class MarcBibToInstanceMapper extends AbstractMapper<MarcRecord, Instance> {

    public MarcBibToInstanceMapper() {
        super(MARC_BIBLIOGRAPHIC, INSTANCE);
    }

    @Override
    public Instance map(MarcRecord marcRecord, List<String> mappingRules) {
        return new Instance();
    }
}
