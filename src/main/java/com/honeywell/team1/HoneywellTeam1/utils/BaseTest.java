package com.honeywell.team1.HoneywellTeam1.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.honeywell.team1.HoneywellTeam1.config.BaseURI;

public class BaseTest {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = BaseURI.PROD+BaseURI.API_VERSION;

    }
}