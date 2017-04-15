package store;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;
import com.honeywell.team1.HoneywellTeam1.config.BasePath;
import com.honeywell.team1.HoneywellTeam1.config.BaseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * Created by apple on 4/8/17.
 */
public class PostStoreOrder {

    @Test
    public void placeOrder(){
        ResponseBody response = given().contentType(ContentType.JSON).
                baseUri(BaseURI.PROD+BaseURI.API_VERSION).
                basePath(BasePath.postOrder()).
                body("{\n" +
                "  \"id\": 9087,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2017-04-08T07:36:25.412Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}").
                when().
                post("/").
                thenReturn().body();

        System.out.println(response.asString());

        AssertJUnit.assertEquals("placed", response.jsonPath().get("status").toString());
        AssertJUnit.assertEquals("true", response.jsonPath().get("complete").toString());
    }
}