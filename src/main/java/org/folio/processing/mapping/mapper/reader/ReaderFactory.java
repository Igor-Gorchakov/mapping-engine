package org.folio.processing.mapping.mapper.reader;


import java.util.Map;

import static org.folio.processing.mapping.model.context.MappingProfile.EntityType;

public interface ReaderFactory {

    static ReaderFactory factory() {
        return new ReaderFactoryImpl();
    }

    Reader build(EntityType entityType, Map<String, Object> eventContextObjects);

    Reader registerReader(Reader reader);
}
