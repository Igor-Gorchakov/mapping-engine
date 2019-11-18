package org.folio.processing.mapping;

import org.folio.Registry;
import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.model.EventContext;
import org.folio.processing.mapping.model.MappingProfile;

import java.util.Optional;


public class MappingManager {

    @SuppressWarnings("unchecked")
    public static EventContext map(EventContext eventContext) {
        MappingProfile mappingProfile = eventContext.getMappingProfile();
        MappingProfile.SourceType sourceType = mappingProfile.getSourceType();
        MappingProfile.TargetType targetType = mappingProfile.getTargetType();

        Optional<Mapper> optionalMapper = findMapper(sourceType, targetType);
        if (optionalMapper.isPresent()) {
            try {
                Mapper mapper = optionalMapper.get();
                mapper.map(eventContext);
            } catch (Exception e) {
                // logger - exception occurred
            }
        } else {
            // logger - no mapper found
        }
        return eventContext;
    }

    private static Optional<Mapper> findMapper(MappingProfile.SourceType profileSourceType, MappingProfile.TargetType profileTargetType) {
        return Registry.mappers.stream()
                .filter(mapper -> mapper.getSourceType().equals(profileSourceType) && mapper.getTargetType().equals(profileTargetType))
                .findFirst();
    }
}
