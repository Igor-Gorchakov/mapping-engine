package org.folio.processing.mapping.mapper.value;

public class ListValue implements Value<java.util.List<StringValue>> {
    private final java.util.List<StringValue> list;

    public ListValue(java.util.List<StringValue> list) {
        this.list = list;
    }

    @Override
    public java.util.List<StringValue> getValue() {
        return null;
    }
}
