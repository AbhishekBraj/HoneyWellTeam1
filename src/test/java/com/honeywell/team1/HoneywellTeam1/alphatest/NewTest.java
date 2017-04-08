package com.honeywell.team1.HoneywellTeam1.alphatest;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.io.File;

public class NewTest {
	
	
  @Test
  public void inventoryGet() {
	  
	   Response str = when().get("http://petstore.swagger.io/v2/store/inventory")
			  .thenReturn();
	  //System.out.println(str.getBody().asString());
  }
  
  @Test
  public void getPets(){
	  File file = new File(System.getProperty("user.dir")+"//resources//petAddTest.json");
	  
	  Response res = given().contentType("application/json").body(file).when().post("http://petstore.swagger.io/v2/pet").thenReturn();
	  System.out.println(res.getBody().asString());
	  
	  System.out.println(res.jsonPath().get("id").toString());
	  System.out.println(res.jsonPath().get("tags[0].name").toString());
	  
	  assertEquals(res.jsonPath().get("tags[0].name").toString(), "string" );
  }
  
  @Test
  public void testAssertionsInRestAssured(){
	  File file = new File(System.getProperty("user.dir")+"//resources//postdata.json");
	  
	  int status = given().contentType("application/json").body(file).when().post("http://petstore.swagger.io/v2/pet").thenReturn().statusCode();
	  System.out.println(status);
  }
}
























