/**
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zalando.stups.fullstop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.plugin.core.config.EnablePluginRegistries;

import org.zalando.stups.fullstop.plugin.FullstopPlugin;

/**
 * @author  jbellmann
 */
@SpringBootApplication
@EnablePluginRegistries({ FullstopPlugin.class })
public class Fullstop {

    public static void main(final String[] args) {
        SpringApplication.run(Fullstop.class, args);
    }
}
