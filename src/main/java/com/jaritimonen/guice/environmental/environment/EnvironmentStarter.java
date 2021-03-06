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

import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.jaritimonen.guice.environmental.di.InjectorHolder;

public class EnvironmentStarter {

    public void fireUp(final EnvironmentNameResolver nameResolver) {
        List<AbstractModule> abstractModules = new EnvironmentResolver().resolveWith(nameResolver);
        if (abstractModules.isEmpty()) {
            throw new IllegalArgumentException("No environments configured");
        }

        InjectorHolder.getInstance().setInjector(Guice.createInjector(abstractModules));
    }
}
