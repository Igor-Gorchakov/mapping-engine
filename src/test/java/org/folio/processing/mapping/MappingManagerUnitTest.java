package org.folio.processing.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.folio.processing.mapping.model.context.EventContext;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.context.Rule;
import org.folio.processing.mapping.model.schemas.Instance;
import org.folio.processing.mapping.reader.TestMarcBibliographicReaderFactory;
import org.folio.processing.mapping.writer.TestInstanceWriterFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import static org.folio.processing.mapping.model.context.MappingProfile.EntityType.INSTANCE;
import static org.folio.processing.mapping.model.context.MappingProfile.EntityType.MARC_BIBLIOGRAPHIC;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class MappingManagerUnitTest {

    @Test
    public void shouldMap_MarcBibliographicToInstance() throws IOException {
        // given
        String givenMarcRecord = "{ \"leader\":\"01314nam  22003851a 4500\", \"fields\":[ { \"001\":\"ybp7406411\" } ] }";
        String givenInstance = new ObjectMapper().writeValueAsString(new Instance(UUID.randomUUID().toString()));
        MappingProfile mappingProfile = new MappingProfile(MARC_BIBLIOGRAPHIC, INSTANCE);
        mappingProfile.setMappingRules(Arrays.asList(new Rule("indexTitle", "RULE_EXPRESSION")));

        EventContext eventContext = new EventContext();
        eventContext.putObject(MARC_BIBLIOGRAPHIC.value(), givenMarcRecord);
        eventContext.putObject(INSTANCE.value(), givenInstance);
        eventContext.setMappingProfile(mappingProfile);
        // when
        MappingManager.registerReaderFactory(new TestMarcBibliographicReaderFactory());
        MappingManager.registerWriterFactory(new TestInstanceWriterFactory());
        MappingManager.map(eventContext);
        // then
        assertNotNull(eventContext.getObjects().get(MARC_BIBLIOGRAPHIC.value()));
        assertNotNull(eventContext.getObjects().get(INSTANCE.value()));
        Instance mappedInstance = new ObjectMapper().readValue(eventContext.getObjects().get(INSTANCE.value()), Instance.class);
        assertNotNull(mappedInstance.getId());
        assertNotNull(mappedInstance.getIndexTitle());
    }
}
