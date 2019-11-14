package org.folio;

import org.folio.processing.mapping.MappingManager;
import org.folio.processing.mapping.model.MappingProfile;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setSourceType(MappingProfile.SourceType.MARC_BIBLIOGRAPHIC);
        mappingProfile.setTargetType(MappingProfile.TargetType.INVOICE);
        Map<String, Object> mappingContext = new HashMap<>();
        mappingContext.put("mappingProfile", mappingProfile);
        MappingManager.map(mappingContext);
    }
}