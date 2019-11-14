package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.MappingProfile;

import java.util.List;

public interface Mapper<SOURCE, TARGET> {

    TARGET map(SOURCE source, List<String> mappingRules);

    MappingProfile.SourceType getSourceType();

    MappingProfile.TargetType getTargetType();
}
