package org.folio.processing.mapping.mapper.value;

public class StringValue implements Value<java.lang.String> {
    private java.lang.String value;

    public StringValue(java.lang.String value) {
        this.value = value;
    }

    @Override
    public java.lang.String getValue() {
        return value;
    }
}
