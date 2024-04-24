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

import static org.junit.Assert.assertEquals;

public class ConsultGETApi {
    private String url;
    private RequestSpecification request;
    private Response response;
    private configFileReader configFileReader;

    @Before
    public void setUp(Scenario scenario) {
        configFileReader = new configFileReader();
        url = configFileReader.getApplicationUrl("urlSite");
        System.setProperty("webdriver.gecko.driver", "\\chrome\\geckodriver");
        request = RestAssured.with();
    }

    @Given("o usuário deseja efetuar uma consulta via GET na API jsonplaceholder")
    public void userWantsToMakeGetRequestToApi() {
        request.contentType(ContentType.JSON).baseUri(url);
        System.out.println("URL adicionada: " + url);
    }

    @When("pesquisar no endpoint {string} o valor {string}")
    public void insertValueInEndpoint(String endPoint, String value) {
        response = request.get(endPoint + value);
    }

    @Then("o sistema deve retornar o status {string}")
    public void validateResponseStatus(String statusCode) {
        assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }

    @And("o e-mail {string}")
    public void validateEmail(String email) {
        validateJsonList("email", email);
    }

    public void validateJsonList(String key, String expectedValue) {
        java.util.List<String> valueList = response.getBody().jsonPath().getList(key);
        for (String selectvalue : valueList) {
            if (selectvalue.equals(expectedValue)) {
                assertEquals(expectedValue, selectvalue);
                break;
            } else {
                assertEquals(expectedValue, selectvalue);
            }
        }
    }
}