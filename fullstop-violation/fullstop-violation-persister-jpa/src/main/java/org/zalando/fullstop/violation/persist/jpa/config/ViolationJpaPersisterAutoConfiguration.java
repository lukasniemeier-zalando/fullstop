package org.zalando.fullstop.violation.persist.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.zalando.fullstop.violation.persist.jpa.ViolationJpaPersister;
import org.zalando.stups.fullstop.violation.repository.ViolationRepository;
import org.zalando.stups.fullstop.violation.repository.ViolationTypeRepository;
import org.zalando.stups.fullstop.violation.service.ApplicationVersionService;
import org.zalando.stups.fullstop.whitelist.WhitelistRules;
import reactor.bus.EventBus;

/**
 * Autoconfiguration for {@link ViolationJpaPersister}.
 *
 * @author jbellmann
 */
@Configuration
@EnableJpaRepositories("org.zalando.stups.fullstop.violation.repository")
@EnableSpringDataWebSupport
public class ViolationJpaPersisterAutoConfiguration {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private ViolationRepository violationRepository;

    @Autowired
    private ViolationTypeRepository violationTypeRepository;

    @Autowired
    private CounterService counterService;

    @Autowired
    private WhitelistRules whitelistRules;

    @Autowired
    private ApplicationVersionService applicationVersionService;

    @Bean
    public ViolationJpaPersister violationJpaPersister() {
        return new ViolationJpaPersister(eventBus, violationRepository, violationTypeRepository, counterService,
                whitelistRules, applicationVersionService);
    }
}
