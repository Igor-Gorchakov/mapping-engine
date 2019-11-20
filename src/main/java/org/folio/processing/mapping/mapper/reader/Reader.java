package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.mapper.value.Value;

public interface Reader {

    Value read(String rule);
}
