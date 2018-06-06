/*
 * Copyright 2015 Decebal Suiu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.adorsys.sts.pf4j;

import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


public abstract class SpringPlugin extends Plugin {

    private ApplicationContext applicationContext;
    protected ApplicationContext parentApplicationContext;

    public SpringPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    public final ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = createApplicationContext();
        }

        return applicationContext;
    }

    @Override
    public void stop() {
        // close applicationContext
        if ((applicationContext != null) && (applicationContext instanceof ConfigurableApplicationContext)) {
            ((ConfigurableApplicationContext) applicationContext).close();
        }
    }

    protected abstract ApplicationContext createApplicationContext();

    void setParentApplicationContext(ApplicationContext parentApplicationContext) {
        this.parentApplicationContext = parentApplicationContext;
    }
}
