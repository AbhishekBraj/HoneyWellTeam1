package store;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;
import com.honeywell.team1.HoneywellTeam1.config.BasePath;
import com.honeywell.team1.HoneywellTeam1.config.BaseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * Created by apple on 4/8/17.
 */
public class GetOrderId {

    @Test
    public void placeOrder(){
        ResponseBody response = given().contentType(ContentType.JSON).
                baseUri(BaseURI.PROD+BaseURI.API_VERSION).
                basePath(BasePath.postOrder()).
                body("{\n" +
                        "  \"id\": 12345,\n" +
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
        ResponseBody responseBody = given().contentType(ContentType.JSON).
                baseUri(BaseURI.PROD+BaseURI.API_VERSION).
                basePath(BasePath.getOrderId(orderId)).
                when().
                get("/").
                thenReturn().body();

        given().contentType(ContentType.JSON).
                baseUri(BaseURI.PROD+BaseURI.API_VERSION).
                basePath(BasePath.getOrderId(orderId)).
                when().
                get("/").
                then().statusCode(201);

    }
}