package org.folio.processing.mapping.model.context;


import java.util.HashMap;
import java.util.Map;

public class EventContext {
    private MappingProfile mappingProfile;
    private Map<String, String> objects = new HashMap<>();

    public MappingProfile getMappingProfile() {
        return mappingProfile;
    }

    public void setMappingProfile(MappingProfile mappingProfile) {
        this.mappingProfile = mappingProfile;
    }

    public Map<String, String> getObjects() {
        return objects;
    }

    public void setObjects(Map<String, String> objects) {
        this.objects = objects;
    }

    public Object putObject(String key, String object) {
        return this.objects.put(key, object);
    }
}
