package org.folio.processing.mapping.mapper.value;

public enum ValueType {
    STRING,
    LIST;

    public boolean isString() {
        return this == STRING;
    }

    public boolean isList() {
        return this == LIST;
    }
}
