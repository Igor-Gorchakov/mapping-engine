package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.*;

import java.util.List;

import static org.folio.processing.mapping.model.MappingProfile.TargetType.INVOICE;
import static org.folio.processing.mapping.model.MappingProfile.SourceType.MARC_BIBLIOGRAPHIC;

public class MarcBibToInvoiceMapper extends AbstractMapper {

    public MarcBibToInvoiceMapper() {
        super(MARC_BIBLIOGRAPHIC, INVOICE);
    }

    @Override
    public EventContext map(EventContext eventContext) {
        List<String> mappingRules = eventContext.getMappingProfile().getMappingRules();
        Holder<MarcRecord> source = eventContext.getObjects().get("source");
        Invoice target = new Invoice();
        // LOGGER.info mapping from source to target using mapping rules
        eventContext.putObject("mappedInvoice", new Holder<>(target));
        return eventContext;
    }
}