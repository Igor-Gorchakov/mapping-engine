package org.folio.processing.mapping.model.context;


import java.util.HashMap;
import java.util.Map;

public class EventContext {
    private MappingProfile mappingProfile;
    private Map<String, Object> objects = new HashMap<>();

    public MappingProfile getMappingProfile() {
        return mappingProfile;
    }

    public void setMappingProfile(MappingProfile mappingProfile) {
        this.mappingProfile = mappingProfile;
    }

    public Map<String, Object> getObjects() {
        return objects;
    }

    public void setObjects(Map<String, Object> objects) {
        this.objects = objects;
    }

    public Object putObject(String key, Object object) {
        return this.objects.put(key, object);
    }
}
