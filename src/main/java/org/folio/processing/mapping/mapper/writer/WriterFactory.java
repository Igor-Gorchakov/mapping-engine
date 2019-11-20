package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.model.context.MappingProfile.EntityType;

import java.util.Map;

public interface WriterFactory {

    static WriterFactory factory() {
        return new WriterFactoryImpl();
    }

    Writer build(EntityType entityType, Map<String, Object> eventContextObjects);

    Writer registerWriter(Writer writer);
}
