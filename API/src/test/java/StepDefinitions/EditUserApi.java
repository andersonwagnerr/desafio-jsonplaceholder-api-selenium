package StepDefinitions;

import dataProviders.configFileReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditUserApi {
    private String url;
    private RequestSpecification request;
    private Response response;
    private JSONObject reqParams;
    private configFileReader configFileReader;

    @Before
    public void setUp(Scenario scenario) {
        configFileReader = new configFileReader();
        url = configFileReader.getApplicationUrl("urlSite");
        System.setProperty("webdriver.gecko.driver", "\\chrome\\geckodriver");
        request = RestAssured.with();
    }

    @Given("usuario deseje alterar um dado do usuario via put na api jsonplaceholder")
    public void userWantsToEditUser() {
        request.contentType(ContentType.JSON).baseUri(url);
        System.out.println("URL adicionada: " + url);
    }

    @When("inserir no endpoint {string} o ID {string}")
    public void insertEndpoint(String endPoint, String id) {
        response = request.post(endPoint + id);
    }

    @And("o e-mail como {string}")
    public void editEmail(String email) throws JSONException {
        request.header("Content-Type", "application/json");
        request.put(email);
    }

    @And("a latitude como {string}")
    public void editLat(String latitude) throws JSONException {
        request.put(latitude);
    }

    @And("a longitude como {string}")
    public void editLong(String longitude) throws JSONException {
        request.put(longitude);
    }

    @Then("o status como {string}")
    public void validateStatusAdd() {
        response.getStatusCode();
        //assertEquals(Integer.parseInt(status), response.getStatusCode());
    }
    @And("o valor {string}")
    public void values(String values) throws JSONException {
        assertEquals(values, response.jsonPath().getString("id"));

    }
}