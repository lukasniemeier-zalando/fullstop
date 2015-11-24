/**
 * Copyright (C) 2015 Zalando SE (http://tech.zalando.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zalando.stups.fullstop.plugin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.zalando.stups.clients.kio.KioOperations;
import org.zalando.stups.fullstop.aws.ClientProvider;
import org.zalando.stups.fullstop.events.UserDataProvider;
import org.zalando.stups.fullstop.plugin.RegistryPlugin;
import org.zalando.stups.fullstop.violation.ViolationSink;
import org.zalando.stups.pierone.client.PieroneOperations;

@Configuration
@EnableConfigurationProperties({ RegistryPluginProperties.class })
public class RegistryPluginAutoConfiguration {
    @Autowired
    private ClientProvider clientProvider;

    @ConditionalOnMissingBean
    @Bean
    public UserDataProvider userDataProvider() {
        return new UserDataProvider(clientProvider);
    }

    @Bean
    RegistryPlugin registryPlugin(UserDataProvider userDataProvider, ViolationSink violationSink,
                                  PieroneOperations pieroneOperations, KioOperations kioOperations,
                                  RegistryPluginProperties registryPluginProperties) {
        return new RegistryPlugin(userDataProvider, violationSink, pieroneOperations, kioOperations, registryPluginProperties);
    }
}
