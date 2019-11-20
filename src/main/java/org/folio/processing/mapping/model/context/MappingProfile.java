package org.folio.processing.mapping.model.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappingProfile {
    private EntityType incomingRecordType;
    private EntityType existingRecordType;
    private List<String> mappingRules;

    public EntityType getIncomingRecordType() {
        return incomingRecordType;
    }

    public void setIncomingRecordType(EntityType incomingRecordType) {
        this.incomingRecordType = incomingRecordType;
    }

    public EntityType getExistingRecordType() {
        return existingRecordType;
    }

    public void setExistingRecordType(EntityType existingRecordType) {
        this.existingRecordType = existingRecordType;
    }

    public List<String> getMappingRules() {
        return mappingRules;
    }

    public void setMappingRules(List<String> mappingRules) {
        this.mappingRules = mappingRules;
    }

    public enum EntityType {

        INSTANCE("INSTANCE"),
        HOLDINGS("HOLDINGS"),
        ITEM("ITEM"),
        ORDER("ORDER"),
        INVOICE("INVOICE"),
        MARC_BIBLIOGRAPHIC("MARC_BIBLIOGRAPHIC"),
        MARC_HOLDINGS("MARC_HOLDINGS"),
        MARC_AUTHORITY("MARC_AUTHORITY"),
        EDIFACT_INVOICE("EDIFACT_INVOICE"),
        DELIMITED("DELIMITED");
        private final static Map<String, EntityType> CONSTANTS = new HashMap<String, EntityType>();

        static {
            for (EntityType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        private EntityType(String value) {
            this.value = value;
        }

        public static EntityType fromValue(String value) {
            EntityType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

    }
}
