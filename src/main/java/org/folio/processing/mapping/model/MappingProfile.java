package org.folio.processing.mapping.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MappingProfile {
    // type of incoming source
    private SourceType sourceType;
    // type of outcoming mapped target
    private TargetType targetType;

    // rules
    private List<String> mappingRules;


    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public List<String> getMappingRules() {
        return mappingRules;
    }

    public void setMappingRules(List<String> mappingRules) {
        this.mappingRules = mappingRules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MappingProfile that = (MappingProfile) o;
        return sourceType == that.sourceType &&
                targetType == that.targetType &&
                Objects.equals(mappingRules, that.mappingRules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceType, targetType, mappingRules);
    }

    public enum SourceType {

        MARC_BIBLIOGRAPHIC("MARC_BIBLIOGRAPHIC"),
        MARC_HOLDINGS("MARC_HOLDINGS"),
        MARC_AUTHORITY("MARC_AUTHORITY"),
        EDIFACT_INVOICE("EDIFACT_INVOICE"),
        DELIMITED("DELIMITED");
        private final static Map<String, SourceType> CONSTANTS = new HashMap<String, SourceType>();

        static {
            for (SourceType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        private SourceType(String value) {
            this.value = value;
        }

        public static SourceType fromValue(String value) {
            SourceType constant = CONSTANTS.get(value);
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

    public enum TargetType {

        INSTANCE("INSTANCE"),
        HOLDINGS("HOLDINGS"),
        ITEM("ITEM"),
        ORDER("ORDER"),
        INVOICE("INVOICE"),
        MARC_BIBLIOGRAPHIC("MARC_BIBLIOGRAPHIC"),
        MARC_HOLDINGS("MARC_HOLDINGS"),
        MARC_AUTHORITY("MARC_AUTHORITY");
        private final static Map<String, TargetType> CONSTANTS = new HashMap<String, TargetType>();

        static {
            for (TargetType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        private TargetType(String value) {
            this.value = value;
        }

        public static TargetType fromValue(String value) {
            TargetType constant = CONSTANTS.get(value);
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
