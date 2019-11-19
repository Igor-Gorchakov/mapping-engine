package org.folio.processing.mapping.mapper.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.schemas.Instance;

import java.io.IOException;
import java.util.logging.Logger;

import static java.lang.String.format;

public class InstanceWriter implements Writer {
    private final static Logger LOGGER = Logger.getLogger(InstanceWriter.class.getName());

    @Override
    public EventContext write(String sourceEntity, EventContext eventContext) throws IOException {
        String instanceJson = eventContext.getObjects().get("instance");
        Instance instanceObject = new ObjectMapper().readValue(instanceJson, Instance.class);
        MappingProfile.EntityType incomingRecordType = eventContext.getMappingProfile().getIncomingRecordType();
        switch (incomingRecordType) {
            case MARC_AUTHORITY:
                writeMarcAuthorityToInstance(sourceEntity, instanceObject, eventContext);
                break;
            case MARC_BIBLIOGRAPHIC:
                writeMarcBibliographicToInstance(sourceEntity, instanceObject, eventContext);
                break;
            case MARC_HOLDINGS:
                writeMarcHoldingsToInstance(sourceEntity, instanceObject, eventContext);
                break;
            default:
                throw new IllegalArgumentException("No writer registered for incoming record type " + incomingRecordType);
        }
        eventContext.putObject("instance", new ObjectMapper().writeValueAsString(instanceObject));
        return eventContext;
    }

    private void writeMarcAuthorityToInstance(String marcAuthorityRecord, Instance instance, EventContext eventContext) {
        LOGGER.info(format("Mapping instance %s from marc authority record", instance.getId()));
        instance.setName("Instance from the Marc Authority record");
    }

    private void writeMarcHoldingsToInstance(String marcHoldingRecord, Instance instance, EventContext eventContext) {
        LOGGER.info(format("Mapping instance %s from marc holding record", instance.getId()));
        instance.setName("Instance from the Marc Holding record");
    }

    private void writeMarcBibliographicToInstance(String marcBibliographicRecord, Instance instance, EventContext eventContext) {
        LOGGER.info(format("Mapping instance %s from marc bibliographic record", instance.getId()));
        instance.setName("Instance from the Marc Bibliographic record");
    }
}
