package store;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;
import com.honeywell.team1.HoneywellTeam1.config.BasePath;
import com.honeywell.team1.HoneywellTeam1.config.BaseURI;
import static  org.testng.Assert.*;
import static io.restassured.RestAssured.given;

/**
 * Created by apple on 4/8/17.
 */
public class DeleteOrderId {

    @Test
    public void deleteOrderId(){
        ResponseBody response = given().contentType(ContentType.JSON).
                baseUri(BaseURI.PROD+BaseURI.API_VERSION).
                basePath(BasePath.deleteOrderId(1234)).
                when().
                post("/").
                thenReturn().body();

        System.out.println(response.asString());
    }
}