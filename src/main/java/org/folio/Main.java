package org.folio;

import org.folio.processing.mapping.MappingManager;
import org.folio.processing.mapping.model.Invoice;
import org.folio.processing.mapping.model.MappingProfile;
import org.folio.processing.mapping.model.MarcRecord;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        MappingProfile mappingProfile = new MappingProfile();
        mappingProfile.setSourceType(MappingProfile.SourceType.MARC_BIBLIOGRAPHIC);
        mappingProfile.setTargetType(MappingProfile.TargetType.INVOICE);

        MarcRecord source = new MarcRecord();

        Optional<Invoice> optionalInvoice = MappingManager.map(source, mappingProfile);

        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();
            System.out.println(invoice);
        }
    }
}