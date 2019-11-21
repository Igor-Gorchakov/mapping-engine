package org.folio.processing.mapping;

import org.folio.processing.mapping.mapper.FactoryRegistry;
import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.reader.ReaderFactory;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.mapper.writer.WriterFactory;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;

import java.util.logging.Logger;

public final class MappingManager {
    private final static Logger LOGGER = Logger.getLogger(MappingManager.class.getName());
    private static final FactoryRegistry FACTORY_REGISTRY = new FactoryRegistry();

    private MappingManager() {
    }

    public static EventContext map(EventContext eventContext) {
        try {
            MappingProfile mappingProfile = eventContext.getMappingProfile();
            Reader reader = FACTORY_REGISTRY.createReader(mappingProfile.getIncomingRecordType());
            Writer writer = FACTORY_REGISTRY.createWriter(mappingProfile.getExistingRecordType());
            new Mapper(reader, writer).map(eventContext);
        } catch (Exception e) {
            LOGGER.warning("Exception occurred in Mapper " + e.getMessage());
        }
        return eventContext;
    }

    public static boolean registerReaderFactory(ReaderFactory factory) {
        return FACTORY_REGISTRY.registerReaderFactory(factory);
    }

    public static boolean registerWriterFactory(WriterFactory factory) {
        return FACTORY_REGISTRY.registerWriterFactory(factory);
    }
}
