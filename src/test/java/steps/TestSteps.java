package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestSteps {

    protected static Response response;

   //  Scenario 01: Verify availability of "St John" in the list of Charities

    @When("GET operation is performed to get a list of charities")
    public void getOperationIsPerformedToGetAListOfCharities() {
        String charitiesEndpoint = System.getProperty("charities.endpoint");
        response = given().contentType(ContentType.JSON)
                .when().get(System.getProperty("app.url") + charitiesEndpoint)
                .then().contentType(ContentType.JSON).extract().response();
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }


    @And("the charities list should include {string}")
    public void theCharitiesListShouldInclude(String name) {
        assertThat(response.getBody().jsonPath().get("Description"), hasItem(name));
    }


 // Scenario 02: Verify attributes of a book listing

    @When("^I send a GET request to retrieve details of a (.+)$")
    public void i_send_a_get_request_to_retrieve_details_of_a(String bookListing){
        String listingEndpoint = System.getProperty("listing.endpoint");
        response =
                given()
                        .contentType(ContentType.JSON)
                        .auth()
                        .oauth(System.getProperty("tm.consumerKey"),
                                System.getProperty("tm.consumerSecret"),
                                System.getProperty("tm.accessToken"),
                                System.getProperty("tm.secretToken"))
                        .when()
                        .get(System.getProperty("app.url")+ listingEndpoint + bookListing +".json")
                        .then()
                        .contentType(ContentType.JSON).extract().response();

    }

    @Then("the status code of the response is {int}")
    public void theStatusCodeOfTheResponseIs(int statusCode) {
       Assert.assertEquals(response.statusCode(), statusCode);
    }

    @And("the listing has {string}")
    public void theListingHas(String key) {
        JsonPath jPath = response.getBody().jsonPath();
        Assert.assertNotNull(jPath.get(key), key + " is not found in the response");
    }
}
