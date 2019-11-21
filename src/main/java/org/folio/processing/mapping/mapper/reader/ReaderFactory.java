package org.folio.processing.mapping.mapper.reader;

import static org.folio.processing.mapping.model.context.MappingProfile.EntityType;

public interface ReaderFactory {

    Reader createReader();

    EntityType getEntityType();
}
