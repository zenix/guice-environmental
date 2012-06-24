package com.jaritimonen.guice.environmental.environment;

import com.jaritimonen.guice.environmental.di.InjectorHolder;
import jdave.Block;
import jdave.Specification;
import jdave.junit4.JDaveRunner;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;

@RunWith(JDaveRunner.class)
public class EnvironmentStarterTest extends Specification<EnvironmentStarter> {

    public class WhenStartingEnvironmentAndEverythingIsNotRight {

        public EnvironmentStarter create() {
            return new EnvironmentStarter();
        }

        public void thenThrowException() {
            specify(new Block() {
                public void run() throws Throwable {
                    context.fireUp(new EmptyEnvironmentNameResolver());
                }
            }, must.raiseExactly(IllegalArgumentException.class));
        }
    }

    public class WhenStartingEnvironmentAndAllIsOk {

        public EnvironmentStarter create() {
            return new EnvironmentStarter();
        }

        public void thenModulesThenInjectorIsNotEmpty() {
            context.fireUp(new EnvironmentNameResolver() {
                public String getEnvironmentProperty() {
                    return "DEVELOPMENT";
                }
            });
            specify(InjectorHolder.getInstance().getInjector(), Matchers.notNullValue());
        }
    }

}
