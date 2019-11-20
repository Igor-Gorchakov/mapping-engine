package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.mapper.value.ValueContainer;

public interface Reader {

    ValueContainer read(String rule);
}
