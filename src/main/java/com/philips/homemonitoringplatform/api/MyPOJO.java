package com.philips.homemonitoringplatform.api;

import com.lightbend.lagom.serialization.Jsonable;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString

public class MyPOJO implements Jsonable {

    String name;
}
