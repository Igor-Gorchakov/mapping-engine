package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.EventContext;
import org.folio.processing.mapping.model.Holder;
import org.folio.processing.mapping.model.Instance;
import org.folio.processing.mapping.model.MarcRecord;

import java.util.List;

import static org.folio.processing.mapping.model.MappingProfile.SourceType.MARC_BIBLIOGRAPHIC;
import static org.folio.processing.mapping.model.MappingProfile.TargetType.INSTANCE;

public class MarcBibToInstanceMapper extends AbstractMapper {

    public MarcBibToInstanceMapper() {
        super(MARC_BIBLIOGRAPHIC, INSTANCE);
    }

    @Override
    public EventContext map(EventContext eventContext) {
        List<String> mappingRules = eventContext.getMappingProfile().getMappingRules();
        Holder<MarcRecord> source = eventContext.getObjects().get("source");
        Instance target = new Instance();
        // LOGGER.info mapping from source to target using mapping rules
        eventContext.putObject("mappedInstance", new Holder<>(target));
        return eventContext;
    }
}
