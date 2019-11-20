package org.folio.processing.mapping.mapper.writer;

import org.folio.processing.mapping.mapper.value.ValueContainer;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.schemas.Instance;

public class InstanceWriter implements Writer {
    private Instance instance;

    public InstanceWriter(Instance instance) {
        this.instance = instance;
    }

    @Override
    public void write(String rule, ValueContainer value) {

    }

    public EventContext end(EventContext eventContext) {
            eventContext.putObject("instance", instance);
            return eventContext;
    }
}
