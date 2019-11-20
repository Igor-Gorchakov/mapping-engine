package org.folio.processing.mapping;

import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.reader.ReaderFactory;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.mapper.writer.WriterFactory;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile.EntityType;

import java.util.logging.Logger;

public final class MappingManager {
    private final static Logger LOGGER = Logger.getLogger(MappingManager.class.getName());
    private static final ReaderFactory readerFactory = ReaderFactory.factory();
    private static final WriterFactory writerFactory = WriterFactory.factory();
    private static final Mapper MAPPER = new Mapper(readerFactory, writerFactory);

    private MappingManager() {
    }

    public static EventContext map(EventContext eventContext) {
        try {
            MAPPER.map(eventContext);
        } catch (Exception e) {
            LOGGER.warning("Exception occurred in Mapper " + e.getMessage());
        }
        return eventContext;
    }

    public static Reader registerReader(Reader reader, EntityType entityType) {
        return readerFactory.registerReader(reader, entityType);
    }

    public static Writer registerWriter(Writer writer, EntityType entityType) {
        return writerFactory.registerWriter(writer, entityType);
    }
}
