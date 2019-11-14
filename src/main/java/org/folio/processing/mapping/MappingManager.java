package org.folio.processing.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.mapper.MarcBibToInstanceMapper;
import org.folio.processing.mapping.mapper.MarcBibToInvoiceMapper;
import org.folio.processing.mapping.model.Holder;
import org.folio.processing.mapping.model.MappingProfile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class MappingManager {
    private static final List<Mapper> mappers = Arrays.asList(
            new MarcBibToInstanceMapper(),
            new MarcBibToInvoiceMapper()
    );

    public static void map(Map<String, Object> mappingContext) {
        MappingProfile mappingProfile = (MappingProfile) mappingContext.get("mappingProfile");

        MappingProfile.SourceType sourceType = mappingProfile.getSourceType();
        MappingProfile.TargetType targetType = mappingProfile.getTargetType();

        Optional<Mapper> optionalMapper = findMapper(sourceType, targetType);
        if (optionalMapper.isPresent()) {
            Mapper mapper = optionalMapper.get();
            List<String> mappingRules = mappingProfile.getMappingRules();
            try {
                Holder<?> targetHolder = new Holder<>(mapper.map(null, mappingRules));
                System.out.println(targetHolder.getValue().getClass());
            } catch (Exception e) {
                // logger - exception occurred
            }
        } else {
            // logger - no mapper found
        }
    }

    private static Optional<Mapper> findMapper(MappingProfile.SourceType profileSourceType, MappingProfile.TargetType profileTargetType) {
        return mappers.stream()
                .filter(mapper ->
                        mapper.getSourceType().equals(profileSourceType) && mapper.getTargetType().equals(profileTargetType))
                .findFirst();
    }
}
