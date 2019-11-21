package org.folio.processing.mapping.mapper.reader;

import static org.folio.processing.mapping.model.context.MappingProfile.EntityType;

/**
 * Factory to produce readers
 *
 * @see Reader
 * @see EntityType
 */
public interface ReaderFactory {

    /**
     * Creates a reader
     *
     * @return reader
     */
    Reader createReader();

    /**
     * Returns type of entity with which Reader operates
     *
     * @return entity type
     */
    EntityType getEntityType();
}
