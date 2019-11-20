package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.schemas.Instance;

import java.util.Map;

public class WriterFactoryImpl implements WriterFactory {
    @Override
    public Writer build(MappingProfile.EntityType entityType, Map<String, Object> eventContextObjects) {
        if (MappingProfile.EntityType.INSTANCE.equals(entityType)) {
            Instance instance = findInstance(eventContextObjects);
            return new InstanceWriter(instance);
        }
        return null;
    }

    private Instance findInstance(Map<String, Object> eventContextObjects) {
        Instance instance = (Instance) eventContextObjects.get("instance");
        return instance;
    }

    @Override
    public Writer registerWriter(Writer writer) {
        throw new UnsupportedOperationException("Writer registration is not supported");
    }
}
