package org.folio.processing.mapping.model;

public final class Holder<T> {
    private final T value;

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
