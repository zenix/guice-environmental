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
package com.jaritimonen.guice.environmental.di;

import com.google.inject.Injector;

public class InjectorHolder {

    private static InjectorHolder INSTANCE = new InjectorHolder();
    private Injector injector;

    private InjectorHolder() {
    }

    public static InjectorHolder getInstance() {
        return INSTANCE;
    }

    public void setInjector(final Injector injector) {
        this.injector = injector;
    }

    public Injector getInjector() {
        return injector;
    }

}
