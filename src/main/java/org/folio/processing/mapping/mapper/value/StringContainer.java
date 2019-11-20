package org.folio.processing.mapping.mapper.value;

public class StringContainer implements ValueContainer<String> {
    private String value;

    public StringContainer(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
