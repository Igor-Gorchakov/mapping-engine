package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.mapper.reader.ReaderFactory;
import org.folio.processing.mapping.mapper.reader.ReaderFactoryImpl;
import org.folio.processing.mapping.model.context.MappingProfile.EntityType;

import java.util.Map;

public interface WriterFactory {

    Writer build(EntityType entityType, Map<String, Object> eventContextObjects);

    Writer registerWriter(Writer writer, EntityType entityType);

    static WriterFactory factory() {
        return new WriterFactoryImpl();
    }
}
