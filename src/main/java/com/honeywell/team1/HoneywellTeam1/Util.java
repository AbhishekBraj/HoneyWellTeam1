package com.honeywell.team1.HoneywellTeam1;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

import io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Util {
	
	public static String baseURL = "http://petstore.swagger.io/v2";
	public static ExtentReports extent = new ExtentReports("Extent.html", true);
	
}
