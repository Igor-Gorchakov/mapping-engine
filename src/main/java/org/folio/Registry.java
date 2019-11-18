package org.folio;

import org.folio.processing.mapping.mapper.Mapper;
import org.folio.processing.mapping.mapper.MarcBibToInstanceMapper;
import org.folio.processing.mapping.mapper.MarcBibToInvoiceMapper;

import java.util.Arrays;
import java.util.List;

public final class Registry {

    public static final List<Mapper> mappers = Arrays.asList(
            new MarcBibToInstanceMapper(),
            new MarcBibToInvoiceMapper()
    );

    private Registry() {
    }
}
