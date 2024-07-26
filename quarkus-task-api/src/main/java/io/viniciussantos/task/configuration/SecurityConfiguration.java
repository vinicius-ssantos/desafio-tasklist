package io.viniciussantos.task.configuration;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.CorsHandler;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class SecurityConfiguration {

    @Inject
    Router router;

    @PostConstruct
    public void init() {
        Set<String> allowedHeaders = new HashSet<>();
        allowedHeaders.add("Authorization");
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("X-Requested-With");

        Set<HttpMethod> allowedMethods = new HashSet<>();
        allowedMethods.add(HttpMethod.GET);
        allowedMethods.add(HttpMethod.POST);
        allowedMethods.add(HttpMethod.PUT);
        allowedMethods.add(HttpMethod.DELETE);
        allowedMethods.add(HttpMethod.OPTIONS);

        CorsHandler corsHandler = CorsHandler.create("*")
                .allowedHeaders(allowedHeaders)
                .allowedMethods(allowedMethods)
                .allowCredentials(true);

        router.route().handler(corsHandler);
    }
}