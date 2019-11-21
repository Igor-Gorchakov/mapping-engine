package org.folio.processing.mapping.mapper.value;

public interface Value<T> {
    T getValue();

    ValueType getType();
}
