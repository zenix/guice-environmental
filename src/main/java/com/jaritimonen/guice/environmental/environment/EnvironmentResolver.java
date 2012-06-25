/**
 *  Copyright 2012 Jari Timonen
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.jaritimonen.guice.environmental.environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.inject.AbstractModule;
import com.jaritimonen.guice.environmental.di.DevelopmentModule;
import com.jaritimonen.guice.environmental.di.ProductionModule;
import com.jaritimonen.guice.environmental.di.TestModule;

public class EnvironmentResolver {

    public List<AbstractModule> resolveWith(EnvironmentNameResolver nameResolver) {
        List<AbstractModule> environments = new ArrayList<AbstractModule>();
        String environment = nameResolver.getEnvironmentProperty();
        for (AbstractModule abstractModule : getEnvironments()) {
            Environment annotation = abstractModule.getClass().getAnnotation(Environment.class);
            if (isNotNull(annotation) && match(environment, annotation)) {
                environments.add(abstractModule);
            }
        }
        return environments;
    }

    private boolean match(String environment, Environment annotation) {
        return annotation.value().equalsIgnoreCase(environment);
    }

    private boolean isNotNull(Environment annotation) {
        return annotation != null && annotation.value() != null;
    }

    protected List<AbstractModule> getEnvironments() {
        return Arrays.asList(new ProductionModule(), new TestModule(), new DevelopmentModule());
    }
}
