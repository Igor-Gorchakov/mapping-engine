package org.folio.processing.mapping;

import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.model.MappingProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MappingManager {
    private static final List<Mapper> mappers = new ArrayList<Mapper>();

    public static void map(Map<String, String> mappingContext) {
        Optional<Mapper> optionalMapper = mappers.stream().findFirst();
        if (optionalMapper.isPresent()) {
            Mapper mapper = optionalMapper.get();
            MappingProfile mappingProfile = mappingContext.get("mappingProfile");
            try {
                mapper.map(mappingProfile);
            } catch (Exception e) {
                // logger
            }
        } else {
            // logger
        }
    }
}
