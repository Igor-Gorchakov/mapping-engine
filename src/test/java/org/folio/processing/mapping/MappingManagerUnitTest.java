package org.folio.processing.mapping;

import org.folio.processing.mapping.model.EventContext;
import org.folio.processing.mapping.model.MappingProfile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MappingManagerUnitTest {

    @Test
    public void marcBibToInstance() {
        // given
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setSourceType(MappingProfile.SourceType.MARC_BIBLIOGRAPHIC);
        mappingProfile.setTargetType(MappingProfile.TargetType.INSTANCE);
        EventContext eventContext = new EventContext();
        eventContext.setMappingProfile(mappingProfile);
        // when
        MappingManager.map(eventContext);
        // then
        Assert.assertNotNull(eventContext.getObjects());
        Assert.assertNotNull(eventContext.getObjects().get("mappedInstance"));
    }

    @Test
    public void marcBibToInvoice() {
        // given
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setSourceType(MappingProfile.SourceType.MARC_BIBLIOGRAPHIC);
        mappingProfile.setTargetType(MappingProfile.TargetType.INVOICE);
        EventContext eventContext = new EventContext();
        eventContext.setMappingProfile(mappingProfile);
        // when
        MappingManager.map(eventContext);
        // then
        Assert.assertNotNull(eventContext.getObjects());
        Assert.assertNotNull(eventContext.getObjects().get("mappedInvoice"));
    }
}
