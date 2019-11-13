package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.Instance;
import org.folio.processing.mapping.model.MappingProfile;
import org.folio.processing.mapping.model.MarcRecord;

public class MarcRecordToInstanceMapper implements Mapper<MarcRecord, Instance> {

    public Instance map(MarcRecord marcRecord, MappingProfile mappingProfile) {
        return new Instance();
    }
}
