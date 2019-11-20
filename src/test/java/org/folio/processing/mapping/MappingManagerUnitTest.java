package org.folio.processing.mapping;

import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.context.Rule;
import org.folio.processing.mapping.model.schemas.Instance;
import org.folio.processing.mapping.model.schemas.MarcBibliographicRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class MappingManagerUnitTest {

    @Test
    public void shouldMap_MarcBibliographicToInstance() {
        // given
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setIncomingRecordType(MappingProfile.EntityType.MARC_BIBLIOGRAPHIC); // FROM
        mappingProfile.setExistingRecordType(MappingProfile.EntityType.INSTANCE);           // TO
        mappingProfile.setMappingRules(Arrays.asList(new Rule("indexTitle", "SET indexTitle")));

        EventContext eventContext = new EventContext();
        eventContext.putObject("marcBibliographicRecord", new MarcBibliographicRecord());   // FROM
        eventContext.putObject("instance", new Instance(UUID.randomUUID().toString()));     // TO
        eventContext.setMappingProfile(mappingProfile);
        // when
        MappingManager.map(eventContext);
        // then
        assertNotNull(eventContext.getObjects().get("instance"));
        Instance instance = (Instance) eventContext.getObjects().get("instance");
        assertNotNull(instance.getId());
        assertNotNull(instance.getName());
    }
}
