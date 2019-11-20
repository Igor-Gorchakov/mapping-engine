package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.schemas.Instance;
import org.folio.processing.mapping.mapper.value.StringValue;
import org.folio.processing.mapping.mapper.value.Value;

public class InstanceWriter implements Writer {
    private Instance instance;

    public InstanceWriter(Instance instance) {
        this.instance = instance;
    }

    @Override
    public void write(String field, Value value) {
        this.instance.setName(((StringValue) value).getValue());
    }

    public EventContext end(EventContext eventContext) {
        eventContext.putObject("instance", instance);
        return eventContext;
    }
}
