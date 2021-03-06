package com.predic8.membrane.starter.dsl;

import com.predic8.membrane.core.config.Path;
import com.predic8.membrane.core.rules.ServiceProxy;
import org.springframework.http.HttpMethod;

public class MatcherSpecification {
    private final ServiceProxy serviceProxy;

    public MatcherSpecification(ServiceProxy serviceProxy) {
        this.serviceProxy = serviceProxy;
    }

    public MatcherSpecification method(HttpMethod method) {
        serviceProxy.setMethod(method.toString());

        return this;
    }

    public MatcherSpecification pathPrefix(String pathPrefix) {
        serviceProxy.setPath(new Path(false, pathPrefix));

        return this;
    }

    public MatcherSpecification pathRegex(String pathRegex) {
        serviceProxy.setPath(new Path(true, pathRegex));

        return this;
    }
}