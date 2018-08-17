package com.philips.homemonitoringplatform.impl;

import akka.Done;
import akka.stream.javadsl.Flow;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.philips.homemonitoringplatform.api.MyPOJO;
import com.philips.homemonitoringplatform.api.NotificationService;

@Singleton
public class NotificationConsumer {
    private final NotificationService notificationService;

    @Inject
    public NotificationConsumer(NotificationService notificationService) {
        System.out.println("in consructor");
        this.notificationService = notificationService;
        notificationService.greetingsTopic().subscribe().atLeastOnce(
                Flow.fromFunction(this::displayMessage));
    }

    private Done displayMessage(MyPOJO message) {
        System.out.println("My Message " + message);
        return Done.getInstance();
    }
}
