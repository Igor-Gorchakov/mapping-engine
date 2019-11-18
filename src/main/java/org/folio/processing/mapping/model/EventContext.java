package org.folio.processing.mapping.model;

import java.util.HashMap;
import java.util.Map;

public class EventContext {
    private MarcRecord marcRecord;
    private MappingProfile mappingProfile;
    private Map<String, Holder> mappingContext = new HashMap<>();

    public MarcRecord getMarcRecord() {
        return marcRecord;
    }

    public void setMarcRecord(MarcRecord marcRecord) {
        this.marcRecord = marcRecord;
    }

    public MappingProfile getMappingProfile() {
        return mappingProfile;
    }

    public void setMappingProfile(MappingProfile mappingProfile) {
        this.mappingProfile = mappingProfile;
    }

    public Map<String, Holder> getMappingContext() {
        return mappingContext;
    }

    public <T> void putToMappingContext(String key, T value) {
        this.mappingContext.put(key, new Holder<>(value));
    }

    @SuppressWarnings(value = "unchecked")
    public <T> Holder<T> getFromMappingContext(String key) {
        return this.mappingContext.get(key);
    }
}
