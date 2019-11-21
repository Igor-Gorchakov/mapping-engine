package org.folio.processing.mapping.mapper.writer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.model.context.EventContext;

import java.io.IOException;

public interface Writer {

    void initialize(EventContext eventContext) throws IOException;

    void write(String fieldPath, Value value);

    void end(EventContext eventContext) throws JsonProcessingException;
}
