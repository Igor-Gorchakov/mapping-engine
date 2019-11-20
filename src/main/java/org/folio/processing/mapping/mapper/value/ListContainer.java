package org.folio.processing.mapping.mapper.value;

import java.util.List;

public class ListContainer implements ValueContainer<List<String>> {
    private final List<String> list;

    public ListContainer(List<String> list) {
        this.list = list;
    }

    @Override
    public List<String> getValue() {
        return null;
    }
}
