package org.folio.processing.mapping.mapper;

import org.folio.processing.mapping.model.EventContext;
import org.folio.processing.mapping.model.Instance;
import org.folio.processing.mapping.model.MarcRecord;

import java.util.List;
import java.util.logging.Logger;

import static org.folio.processing.mapping.model.MappingProfile.SourceType.MARC_BIBLIOGRAPHIC;
import static org.folio.processing.mapping.model.MappingProfile.TargetType.INSTANCE;

public class MarcBibToInstanceMapper extends AbstractMapper {
    private final Logger LOGGER = Logger.getLogger(MarcBibToInstanceMapper.class.getSimpleName());

    public MarcBibToInstanceMapper() {
        super(MARC_BIBLIOGRAPHIC, INSTANCE);
    }

    @Override
    public EventContext map(EventContext eventContext) {
        List<String> mappingRules = eventContext.getMappingProfile().getMappingRules();
        MarcRecord source = eventContext.getMarcRecord();
        Instance target = new Instance();
        LOGGER.info("Mapping from Marc Record to Instance");
        eventContext.putToMappingContext("mappedInstance", target);
        return eventContext;
    }
}
