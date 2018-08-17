package com.philips.homemonitoringplatform;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.api.ServiceInfo;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.philips.homemonitoringplatform.api.NotificationService;
import com.philips.homemonitoringplatform.impl.NotificationConsumer;
import com.typesafe.config.Config;
import play.Environment;

public class ConfigurationServiceLocatorModule extends AbstractModule implements ServiceGuiceSupport {
    private final Environment environment;
    private final Config config;

    /**
     * A parameterized constructor to initialize the config and Environment object.
     *
     * @param environment environment for the application.
     * @param config      properties configuration.
     */
    public ConfigurationServiceLocatorModule(final Environment environment, final Config config) {
        this.environment = environment;
        this.config = config;
    }

    @Override
    protected void configure() {
        bind(NotificationConsumer.class).asEagerSingleton();

        bindServiceInfo(ServiceInfo.of("NotificationService"));
        bindClient(NotificationService.class);

    }

}
