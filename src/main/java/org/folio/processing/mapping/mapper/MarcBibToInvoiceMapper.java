package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.EventContext;
import org.folio.processing.mapping.model.Invoice;
import org.folio.processing.mapping.model.MarcRecord;

import java.util.List;
import java.util.logging.Logger;

import static org.folio.processing.mapping.model.MappingProfile.SourceType.MARC_BIBLIOGRAPHIC;
import static org.folio.processing.mapping.model.MappingProfile.TargetType.INVOICE;

public class MarcBibToInvoiceMapper extends AbstractMapper {
    private final Logger LOGGER = Logger.getLogger(MarcBibToInvoiceMapper.class.getSimpleName());

    public MarcBibToInvoiceMapper() {
        super(MARC_BIBLIOGRAPHIC, INVOICE);
    }

    @Override
    public EventContext map(EventContext eventContext) {
        List<String> mappingRules = eventContext.getMappingProfile().getMappingRules();
        MarcRecord source = eventContext.getMarcRecord();
        Invoice target = new Invoice();
        LOGGER.info("Mapping from Marc Record to Invoice");
        eventContext.putToMappingContext("mappedInvoice", target);
        return eventContext;
    }
}