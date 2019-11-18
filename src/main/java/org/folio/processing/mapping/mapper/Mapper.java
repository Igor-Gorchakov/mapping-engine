package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.EventContext;
import org.folio.processing.mapping.model.MappingProfile;

public interface Mapper {

    EventContext map(EventContext eventContext);

    MappingProfile.SourceType getSourceType();

    MappingProfile.TargetType getTargetType();
}
