package org.folio.processing.mapping.mapper.writer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.model.context.EventContext;

import java.io.IOException;

/**
 * The root interface for writers.
 * The purpose of Writer is to write a given Value to underlying entity by the given fieldPath.
 * Writer has to be initialized before write.
 *
 * @see Value
 */
public interface Writer {

    /**
     * Performs initialization of the writer using event context.
     *
     * @param eventContext event context
     * @throws IOException if a low-level I/O problem occurs (JSON serialization)
     */
    void initialize(EventContext eventContext) throws IOException;

    /**
     * Writes value to the underlying entity by the fieldPath
     *
     * @param fieldPath path to the certain field of the entity
     * @param value     value
     * @see Value
     */
    void write(String fieldPath, Value value);

    /**
     * Ends up writing to the underlying entity.
     *
     * @param eventContext event context
     * @throws JsonProcessingException if JSON serialization problem occurs
     */
    void end(EventContext eventContext) throws JsonProcessingException;
}
