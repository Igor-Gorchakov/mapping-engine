package org.folio.processing.mapping.mapper.writer.factory;

import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.model.context.MappingProfile;

public interface WriterFactory {

    Writer createWriter();

    MappingProfile.EntityType getEntityType();
}
