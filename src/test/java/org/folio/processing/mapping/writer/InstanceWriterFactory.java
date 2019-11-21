package org.folio.processing.mapping.writer;

import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.mapper.writer.WriterFactory;
import org.folio.processing.mapping.model.context.MappingProfile.EntityType;

public class InstanceWriterFactory implements WriterFactory {
    @Override
    public Writer createWriter() {
        return new InstanceWriter();
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.INSTANCE;
    }
}
