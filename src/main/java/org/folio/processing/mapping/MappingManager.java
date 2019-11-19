package org.folio.processing.mapping;


import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.context.MappingProfile.EntityType;

import java.util.logging.Logger;

public final class MappingManager {

    private final static Logger LOGGER = Logger.getLogger(MappingManager.class.getName());
    private static MapperFactory mapperFactory = new MapperFactory();

    public static EventContext map(EventContext eventContext) {
        MappingProfile mappingProfile = eventContext.getMappingProfile();
        Mapper mapper = mapperFactory.buildMapper(mappingProfile);
        try {
            mapper.map(eventContext);
        } catch (Exception e) {
            LOGGER.warning("Exception occurred in Mapper " + e.getMessage());
        }
        return eventContext;
    }

    public static Reader registerReader(EntityType entityType, Reader reader) {
        return mapperFactory.addReader(entityType, reader);
    }

    public static Writer registeWriter(EntityType entityType, Writer writer) {
        return mapperFactory.addWriter(entityType, writer);
    }
}
