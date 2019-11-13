package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.MappingProfile;

public interface Mapper<SOURCE, TARGET> {

    TARGET map(SOURCE source, MappingProfile mappingProfile);
}
