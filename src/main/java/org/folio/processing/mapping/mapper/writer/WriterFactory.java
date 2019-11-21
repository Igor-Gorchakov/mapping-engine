package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.model.context.MappingProfile.EntityType;

/**
 * Factory to produce readers
 *
 * @see Writer
 * @see EntityType
 */
public interface WriterFactory {

    /**
     * Creates a writer
     *
     * @return writer
     */
    Writer createWriter();

    /**
     * Returns type of entity with which Writer operates
     *
     * @return entity type
     */
    EntityType getEntityType();
}
