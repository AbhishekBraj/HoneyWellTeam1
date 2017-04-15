package com.honeywell.team1.HoneywellTeam1.builders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class AuthRequestSpecBuilder {

    RequestSpecification requestSpecification;
    String access_token = "{your access token}";

    public RequestSpecification build(){
        return requestSpecification = new
                RequestSpecBuilder().
                addRequestSpecification(new JSONSpecBuilder().build()).addQueryParam("access_token",access_token).build();
    }
}