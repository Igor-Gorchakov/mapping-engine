package org.folio.processing.mapping;

import org.folio.Registry;
import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.model.EventContext;
import org.folio.processing.mapping.model.MappingProfile;

import java.util.Optional;
import java.util.logging.Logger;

public class MappingManager {
    private final static Logger LOGGER = Logger.getLogger(MappingManager.class.getName());

    public static EventContext map(EventContext eventContext) {
        MappingProfile mappingProfile = eventContext.getMappingProfile();
        MappingProfile.SourceType sourceType = mappingProfile.getSourceType();
        MappingProfile.TargetType targetType = mappingProfile.getTargetType();

        Optional<Mapper> optionalMapper = findMapper(sourceType, targetType);
        if (optionalMapper.isPresent()) {
            Mapper mapper = optionalMapper.get();
            try {
                mapper.map(eventContext);
            } catch (Exception e) {
                LOGGER.warning("Exception occurred in Mapper " + mapper.getClass().getSimpleName());
            }
        } else {
            LOGGER.warning("Can not map, no mapper found for given [source " + sourceType + " target " + targetType + " ]");
        }
        return eventContext;
    }

    private static Optional<Mapper> findMapper(MappingProfile.SourceType profileSourceType, MappingProfile.TargetType profileTargetType) {
        return Registry.mappers.stream()
                .filter(mapper -> mapper.getSourceType().equals(profileSourceType) && mapper.getTargetType().equals(profileTargetType))
                .findFirst();
    }
}
