package org.folio.processing.mapping.model.schemas;

public class Instance {

    private String id;
    private String name;

    public Instance() {
    }

    public Instance(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
