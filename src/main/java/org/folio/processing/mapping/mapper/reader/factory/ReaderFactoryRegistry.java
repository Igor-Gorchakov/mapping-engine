package org.folio.processing.mapping.mapper.reader.factory;

import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.reader.factory.ReaderFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.folio.processing.mapping.model.context.MappingProfile.EntityType;

public class ReaderFactoryRegistry {
    private List<ReaderFactory> readerFactories = new ArrayList<>();

    public Reader createReader(EntityType entityType) {
        Optional<ReaderFactory> optionalReaderFactory = this.readerFactories.stream()
                .filter(readerFactory -> readerFactory.getEntityType().equals(entityType))
                .findFirst();
        if (optionalReaderFactory.isPresent()) {
            ReaderFactory readerFactory = optionalReaderFactory.get();
            return readerFactory.createReader();
        } else {
            throw new IllegalArgumentException("Can not find reader factory by entity type " + entityType);
        }
    }

    public Reader registerReader(Reader reader) {
        throw new UnsupportedOperationException("Reader registration is not supported");
    }
}
