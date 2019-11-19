package org.folio.processing.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.schemas.Instance;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@RunWith(JUnit4.class)
public class MappingManagerUnitTest {

    @Test
    public void marcAuthorityToInstance() throws JsonProcessingException {
        // given
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setIncomingRecordType(MappingProfile.EntityType.MARC_AUTHORITY);
        mappingProfile.setExistingRecordType(MappingProfile.EntityType.INSTANCE);

        String marcAuthorityRecord = new String();
        String matchedInstance = new ObjectMapper().writeValueAsString(new Instance(UUID.randomUUID().toString()));

        EventContext eventContext = new EventContext();
        eventContext.setMappingProfile(mappingProfile);
        eventContext.putObject("marcAuthorityRecord", marcAuthorityRecord);
        eventContext.putObject("instance", matchedInstance);
        // when
        MappingManager.map(eventContext);
        // then
        String instance = eventContext.getObjects().get("instance");
        Assert.assertNotNull(instance);
    }

    @Test
    public void marcBibliographicToInstance() throws JsonProcessingException {
        // given
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setIncomingRecordType(MappingProfile.EntityType.MARC_BIBLIOGRAPHIC);
        mappingProfile.setExistingRecordType(MappingProfile.EntityType.INSTANCE);

        String marcBibliographicRecord = new String();
        String matchedInstance = new ObjectMapper().writeValueAsString(new Instance(UUID.randomUUID().toString()));

        EventContext eventContext = new EventContext();
        eventContext.setMappingProfile(mappingProfile);
        eventContext.putObject("marcBibliographicRecord", marcBibliographicRecord);
        eventContext.putObject("instance", matchedInstance);
        // when
        MappingManager.map(eventContext);
        // then
        String mappedInstance = eventContext.getObjects().get("instance");
        Assert.assertNotNull(mappedInstance);

    }

    @Test
    public void marcHoldingsToInstance() throws JsonProcessingException {
        // given
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setIncomingRecordType(MappingProfile.EntityType.MARC_HOLDINGS);
        mappingProfile.setExistingRecordType(MappingProfile.EntityType.INSTANCE);

        String marcHoldingsRecord = new String();
        String matchedInstance = new ObjectMapper().writeValueAsString(new Instance(UUID.randomUUID().toString()));

        EventContext eventContext = new EventContext();
        eventContext.setMappingProfile(mappingProfile);
        eventContext.putObject("marcHoldingsRecord", marcHoldingsRecord);
        eventContext.putObject("instance", matchedInstance);
        // when
        MappingManager.map(eventContext);
        // then
        String instance = eventContext.getObjects().get("instance");
        Assert.assertNotNull(instance);
    }
}
