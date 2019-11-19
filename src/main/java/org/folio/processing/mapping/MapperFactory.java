package org.folio.processing.mapping;

import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.mapper.reader.MarcAuthorityReader;
import org.folio.processing.mapping.mapper.reader.MarcBibliographicReader;
import org.folio.processing.mapping.mapper.reader.MarcHoldingsReader;
import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.writer.InstanceWriter;
import org.folio.processing.mapping.mapper.writer.Writer;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.context.MappingProfile.EntityType;

import java.util.HashMap;
import java.util.Map;

class MapperFactory {
    private Map<EntityType, Reader> readers = new HashMap<>();
    private Map<EntityType, Writer> writers = new HashMap<>();

    public MapperFactory() {
        initializeReaders();
        initializeWriters();
    }

    public Mapper buildMapper(MappingProfile mappingProfile) {
        MappingProfile.EntityType incomingRecordType = mappingProfile.getIncomingRecordType();
        MappingProfile.EntityType existingRecordType = mappingProfile.getExistingRecordType();

        Reader reader = readers.get(incomingRecordType);
        Writer writer = writers.get(existingRecordType);
        if (reader == null || writer == null) {
            throw new IllegalArgumentException("Wrong mapping profile, check incoming and existing record types");
        } else {
            return new Mapper(reader, writer);
        }
    }

    private void initializeReaders() {
        this.readers.put(EntityType.MARC_AUTHORITY, new MarcAuthorityReader());
        this.readers.put(EntityType.MARC_BIBLIOGRAPHIC, new MarcBibliographicReader());
        this.readers.put(EntityType.MARC_HOLDINGS, new MarcHoldingsReader());
    }

    private void initializeWriters() {
        this.writers.put(EntityType.INSTANCE, new InstanceWriter());
    }

    public Reader addReader(EntityType entityType, Reader reader) {
        return this.readers.put(entityType, reader);
    }

    public Writer addWriter(EntityType entityType, Writer writer) {
        return this.writers.put(entityType, writer);
    }
}
