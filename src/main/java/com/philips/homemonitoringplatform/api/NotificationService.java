package com.philips.homemonitoringplatform.api;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.broker.Topic;

public interface NotificationService extends Service {

    Topic<MyPOJO> greetingsTopic();

    String GREETINGS_TOPIC = "greeting";

    @Override
    default Descriptor descriptor() {
        return Service.named("kafkaService").withTopics(
                Service.topic(GREETINGS_TOPIC, this::greetingsTopic)
        ).withAutoAcl(true);
    }
}
