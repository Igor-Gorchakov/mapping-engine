package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.Invoice;
import org.folio.processing.mapping.model.MarcRecord;

import java.util.List;

import static org.folio.processing.mapping.model.MappingProfile.TargetType.INVOICE;
import static org.folio.processing.mapping.model.MappingProfile.SourceType.MARC_BIBLIOGRAPHIC;

public class MarcBibToInvoiceMapper extends AbstractMapper<MarcRecord, Invoice> {

    public MarcBibToInvoiceMapper() {
        super(MARC_BIBLIOGRAPHIC, INVOICE);
    }

    @Override
    public Invoice map(MarcRecord marcRecord, List<String> mappingRules) {
        return new Invoice();
    }
}