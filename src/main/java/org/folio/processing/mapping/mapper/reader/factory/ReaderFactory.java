package org.folio.processing.mapping.mapper.reader.factory;

import org.folio.processing.mapping.mapper.reader.Reader;

import static org.folio.processing.mapping.model.context.MappingProfile.*;

public interface ReaderFactory {

    Reader createReader();

    EntityType getEntityType();
}
