package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class TestSteps {

   private static Response response;

    @When("GET operation is performed to get a list of charities")
    public void getOperationIsPerformedToGetAListOfCharities() {
        String endpoint = "/v1/Charities.json";
        response = given().contentType(ContentType.JSON)
                .when().get(System.getProperty("app.url") + endpoint)
                .then().contentType(ContentType.JSON).extract().response();
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        Assert.assertEquals(response.statusCode(), 200);
    }


    @And("the charities list should include {string}")
    public void theCharitiesListShouldInclude(String name) {
        assertThat(response.getBody().jsonPath().get("Description"), hasItem(name));
    }


}
