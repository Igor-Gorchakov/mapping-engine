package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.model.schemas.MarcBibliographicRecord;

import java.util.Map;

import static org.folio.processing.mapping.model.context.MappingProfile.EntityType;

public class ReaderFactoryImpl implements ReaderFactory {

    @Override
    public Reader build(EntityType entityType, Map<String, Object> eventContextObjects) {
        if (EntityType.MARC_BIBLIOGRAPHIC.equals(entityType)) {
            MarcBibliographicRecord marcBibliographicRecord = findMarcBibliographic(eventContextObjects);
            return new MarcBibliographicReader(marcBibliographicRecord);
        }
        return null;
    }

    private MarcBibliographicRecord findMarcBibliographic(Map<String, Object> eventContextObjects) {
        MarcBibliographicRecord marcBibliographicRecord = (MarcBibliographicRecord) eventContextObjects.get("marcBibliographicRecord");
        return marcBibliographicRecord;
    }

    @Override
    public Reader registerReader(Reader reader, EntityType entityType) {
        return null;
    }
}
