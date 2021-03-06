package com.honeywell.team1.HoneywellTeam1.alphatest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.*;
import java.io.File;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetTests {
  
 //ExtentTest test;	
 File file;
 Response response;
 //ExtentReports extent = new ExtentReports("Extent.html",true);
 
  @Test()
  public void addNewPetPost() {
	  //test = extent.startTest("Add new Pet Test");
	  file = new File(System.getProperty("user.dir")+ "//resources//petAddTest.json");
	  response = given().contentType("application/json").body(file).when().post("http://petstore.swagger.io/v2/pet").thenReturn();
	  Assert.assertTrue(response.getStatusCode()==200 || response.getStatusCode()==201 , "Response status code is not as expected.");
	  //String responseText = response.getBody().asString();
	  
  }
  
  @Test
  public void  updatePetPut()
  {
	  //test = extent.startTest("Update Pet Details Test");
	  file = new File(System.getProperty("user.dir")+ "//resources//petUpdateExistingPet.json");
	  response = given().contentType("application/json").body(file).when().put("http://petstore.swagger.io/v2/pet").thenReturn();
	  System.out.println(response.getBody().asString());
	  System.out.println(response.getStatusCode());
	  String actualName = response.jsonPath().get("name");
	  Assert.assertTrue(response.getStatusCode()==200 || response.getStatusCode()==201 , "Response status code is not as expected.");
	  Assert.assertTrue(actualName.equalsIgnoreCase("Updated_Doggie"), "Pet Name is not updated.Expected Name::"+ "Updated_Doggie." +" Actual text"+ actualName);
	  
  }
  
}
