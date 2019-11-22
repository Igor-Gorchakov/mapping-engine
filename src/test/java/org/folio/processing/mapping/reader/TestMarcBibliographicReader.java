package org.folio.processing.mapping.reader;

import org.folio.processing.mapping.mapper.reader.Reader;
import org.folio.processing.mapping.mapper.value.StringValue;
import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.Rule;

import static org.folio.processing.mapping.model.context.MappingProfile.EntityType.MARC_BIBLIOGRAPHIC;

public class TestMarcBibliographicReader implements Reader {

    private String marcBibliographicRecord;
    private boolean initialized = true;

    @Override
    public void initialize(EventContext eventContext) {
        if (eventContext.getObjects().containsKey(MARC_BIBLIOGRAPHIC.value())) {
            this.marcBibliographicRecord = eventContext.getObjects().get(MARC_BIBLIOGRAPHIC.value());
            this.initialized = true;
        } else {
            throw new IllegalArgumentException("Can not initialize MarcBibliographicReader, no record found in context");
        }
    }

    @Override
    public Value read(Rule rule) {
        if (initialized) {
            // TODO read index title from record
            return new StringValue("test index title");
        } else {
            throw new IllegalStateException("MarcBibliographicReader has to be initialized before read");
        }
    }
}
