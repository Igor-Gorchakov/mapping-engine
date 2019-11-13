package org.folio;

import org.folio.processing.mapping.MappingManager;
import org.folio.processing.mapping.model.Instance;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> mappingContext = new HashMap<String, String>();
        MappingManager.map(mappingContext);
    }
}