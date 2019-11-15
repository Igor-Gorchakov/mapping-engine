package org.folio.processing.mapping.model;

import java.util.HashMap;
import java.util.Map;

public class EventContext {
    private MarcRecord marcRecord;

    private MappingProfile mappingProfile;
    private Map<String, Holder> objects = new HashMap<>();

    public MappingProfile getMappingProfile() {
        return mappingProfile;
    }

    public void setMappingProfile(MappingProfile mappingProfile) {
        this.mappingProfile = mappingProfile;
    }

    public Map<String, Holder> getObjects() {
        return objects;
    }

    public void setObjects(Map<String, Holder> objects) {
        this.objects = objects;
    }

    public void putObject(String key, Holder object) {
        this.objects.put(key, object);
    }
}
