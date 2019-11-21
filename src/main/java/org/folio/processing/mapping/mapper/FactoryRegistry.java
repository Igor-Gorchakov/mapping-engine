package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.reader.ReaderFactory;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.mapper.writer.WriterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.folio.processing.mapping.model.context.MappingProfile.EntityType;

public class FactoryRegistry {
    private static final List<ReaderFactory> READER_FACTORIES = new ArrayList<>();
    private static final List<WriterFactory> WRITER_FACTORIES = new ArrayList<>();

    public Reader createReader(EntityType entityType) {
        Optional<ReaderFactory> optionalReaderFactory = READER_FACTORIES.stream()
                .filter(readerFactory -> readerFactory.getEntityType().equals(entityType))
                .findFirst();
        if (optionalReaderFactory.isPresent()) {
            ReaderFactory readerFactory = optionalReaderFactory.get();
            return readerFactory.createReader();
        } else {
            throw new IllegalArgumentException("Can not find reader factory by entity type " + entityType);
        }
    }

    public Writer createWriter(EntityType entityType) {
        Optional<WriterFactory> optionalWriterFactory = WRITER_FACTORIES.stream()
                .filter(writerFactory -> writerFactory.getEntityType().equals(entityType))
                .findFirst();
        if (optionalWriterFactory.isPresent()) {
            WriterFactory writerFactory = optionalWriterFactory.get();
            return writerFactory.createWriter();
        } else {
            throw new IllegalArgumentException("Can not find reader factory by entity type " + entityType);
        }
    }


    public boolean registerReaderFactory(ReaderFactory factory) {
        return READER_FACTORIES.add(factory);
    }

    public boolean registerWriterFactory(WriterFactory factory) {
        return WRITER_FACTORIES.add(factory);
    }
}
