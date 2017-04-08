package store;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;
import com.honeywell.team1.HoneywellTeam1.config.BasePath;
import com.honeywell.team1.HoneywellTeam1.config.BaseURI;
import static  org.testng.Assert.*;

import org.testng.Assert;

import static io.restassured.RestAssured.given;

/**
 * Created by apple on 4/8/17.
 */
public class DeleteOrderId {

    @Test
    public void deleteOrderId(){
    	ResponseBody response = given().contentType(ContentType.JSON).
                baseUri(BaseURI.PROD+BaseURI.API_VERSION).
                basePath(BasePath.postOrder()).
                body("{\n" +
                        "  \"id\": 6578,\n" +
                        "  \"petId\": 0,\n" +
                        "  \"quantity\": 0,\n" +
                        "  \"shipDate\": \"2017-04-08T07:36:25.412Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}").
                when().
                post("/").
                thenReturn().body();

        int orderId = response.jsonPath().getInt("id");
        
        ResponseBody del_response = given().contentType(ContentType.JSON).
                baseUri(BaseURI.PROD+BaseURI.API_VERSION).
                //basePath().
                when().
                delete(BasePath.deleteOrderId(orderId)).
                thenReturn().body();

        AssertJUnit.assertEquals("", del_response.asString());
    }
}