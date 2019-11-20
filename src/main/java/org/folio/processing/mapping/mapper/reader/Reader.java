package org.folio.processing.mapping.mapper.reader;

import org.folio.processing.mapping.mapper.value.Value;
import org.folio.processing.mapping.model.context.MappingProfile;
import org.folio.processing.mapping.model.context.Rule;

public interface Reader {

    Value read(Rule rule);

    MappingProfile.EntityType getEntityType();
}
