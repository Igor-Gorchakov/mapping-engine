package org.folio.processing.mapping;

import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.reader.factory.ReaderFactoryRegistry;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.mapper.writer.factory.WriterFactoryRegistry;
import org.folio.processing.mapping.model.context.EventContext;

import java.util.logging.Logger;

public final class MappingManager {
    private final static Logger LOGGER = Logger.getLogger(MappingManager.class.getName());

    private static final ReaderFactoryRegistry READER_FACTORY_REGISTRY = new ReaderFactoryRegistry();
    private static final WriterFactoryRegistry WRITER_FACTORY_REGISTRY = new WriterFactoryRegistry();
    private static final Mapper MAPPER = new Mapper(READER_FACTORY_REGISTRY, WRITER_FACTORY_REGISTRY);

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

    public static Reader registerReader(Reader reader) {
        return READER_FACTORY_REGISTRY.registerReader(reader);
    }

    public static Writer registerWriter(Writer writer) {
        return WRITER_FACTORY_REGISTRY.registerWriter(writer);
    }
}
