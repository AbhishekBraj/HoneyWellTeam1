package store;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.*;
import io.restassured.response.ResponseBody;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import com.honeywell.team1.HoneywellTeam1.config.BasePath;
import com.honeywell.team1.HoneywellTeam1.utils.BaseTest;

/**
 * Created by apple on 4/8/17.
 */
public class GetStoreInventory extends BaseTest{

    @Test
    public void getStatus(){
        ResponseBody resBody = given().
                				when().
                					get(BasePath.getInventory()).
                					thenReturn().body();

        AssertJUnit.assertEquals(resBody.jsonPath().get("stud"), 1);
    }
}