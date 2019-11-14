package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.MappingProfile;

public abstract class AbstractMapper<SOURCE, TARGET> implements Mapper<SOURCE, TARGET> {
    protected MappingProfile.SourceType sourceType;
    protected MappingProfile.TargetType targetType;

    public AbstractMapper(MappingProfile.SourceType sourceType, MappingProfile.TargetType targetType) {
        this.sourceType = sourceType;
        this.targetType = targetType;
    }

    @Override
    public MappingProfile.SourceType getSourceType() {
        return sourceType;
    }

    @Override
    public MappingProfile.TargetType getTargetType() {
        return targetType;
    }
}
