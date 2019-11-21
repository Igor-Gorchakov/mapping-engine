package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.model.context.MappingProfile.EntityType;

public interface WriterFactory {

    Writer createWriter();

    EntityType getEntityType();
}
