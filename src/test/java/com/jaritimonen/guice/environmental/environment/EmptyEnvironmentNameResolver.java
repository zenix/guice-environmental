package com.jaritimonen.guice.environmental.environment;

public class EmptyEnvironmentNameResolver implements EnvironmentNameResolver {

    public String getEnvironmentProperty() {
        return "";
    }
}
