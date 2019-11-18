package org.folio.processing.mapping;

import org.folio.processing.mapping.model.EventContext;
import org.folio.processing.mapping.model.Holder;
import org.folio.processing.mapping.model.Instance;
import org.folio.processing.mapping.model.Invoice;
import org.folio.processing.mapping.model.MappingProfile;
import org.folio.processing.mapping.model.MarcRecord;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MappingManagerUnitTest {

    @Test
    public void marcBibToInstance() {
        // given
        EventContext eventContext = new EventContext();
        eventContext.setMarcRecord(new MarcRecord());
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setSourceType(MappingProfile.SourceType.MARC_BIBLIOGRAPHIC);
        mappingProfile.setTargetType(MappingProfile.TargetType.INSTANCE);
        eventContext.setMappingProfile(mappingProfile);
        // when
        MappingManager.map(eventContext);
        // then
        Holder<Instance> instanceHolder = eventContext.getFromMappingContext("mappedInstance");
        Instance instance = instanceHolder.getValue();
        Assert.assertNotNull(instance);
    }

    @Test
    public void marcBibToInvoice() {
        // given
        EventContext eventContext = new EventContext();
        eventContext.setMarcRecord(new MarcRecord());
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setSourceType(MappingProfile.SourceType.MARC_BIBLIOGRAPHIC);
        mappingProfile.setTargetType(MappingProfile.TargetType.INVOICE);
        eventContext.setMappingProfile(mappingProfile);
        // when
        MappingManager.map(eventContext);
        // then
        Holder<Invoice> invoiceHolder = eventContext.getFromMappingContext("mappedInvoice");
        Invoice invoice = invoiceHolder.getValue();
        Assert.assertNotNull(invoice);
    }
}
