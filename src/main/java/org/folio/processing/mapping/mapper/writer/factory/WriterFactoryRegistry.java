package org.folio.processing.mapping.mapper.writer.factory;


import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.writer.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.folio.processing.mapping.model.context.MappingProfile.*;

public class WriterFactoryRegistry {
    private List<WriterFactory> writerFactories = new ArrayList<>();

    public Writer createWriter(EntityType entityType) {
        Optional<WriterFactory> optionalWriterFactory = this.writerFactories.stream()
                .filter(writerFactory -> writerFactory.getEntityType().equals(entityType))
                .findFirst();
        if (optionalWriterFactory.isPresent()) {
            WriterFactory writerFactory = optionalWriterFactory.get();
            return writerFactory.createWriter();
        } else {
            throw new IllegalArgumentException("Can not find reader factory by entity type " + entityType);
        }
    }

    public Writer registerWriter(Writer writer) {
        throw new UnsupportedOperationException("Reader registration is not supported");
    }
}
