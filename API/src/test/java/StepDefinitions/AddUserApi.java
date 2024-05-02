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

public class AddUserApi {

    private String url;
    private RequestSpecification request;
    private Response response;
    private dataProviders.configFileReader configFileReader;

    @Before
    public void setUp(Scenario scenario) {
        configFileReader = new configFileReader();
        url = configFileReader.getApplicationUrl("urlSite");
        System.setProperty("webdriver.gecko.driver", "\\chrome\\geckodriver");
        request = RestAssured.with();
    }

    @Given("usuario deseje inserir um novo usuario via get na api jsonplaceholder pelo eindpoint {string}")
    public void userWantsToInsertNewUserViaPOST(String endpoint) {
        request.contentType(ContentType.JSON).baseUri(url);
        System.out.println("URL adicionada: " + url);
    }

    @When("enviar o name com o valor {string}")
    public void sendNameWithValue(String name) {
        request.post(name);
    }

    @And("o email com o valor {string}")
    public void sendEmailWithValue(String email) {
        request.post(email);
    }

    @And("o endereço com o valor {string}")
    public void sendStreetWithValue(String street) {
        request.post(street);
    }

    @And("o complemento suite com o valor {string}")
    public void sendComplementWithValue(String Complement) {
        request.post(Complement);
    }

    @And("a cidade com o valor {string}")
    public void sendCityWithValue(String city) {
        request.post(city);
    }

    @And("a telefone com o valor {string}")
    public void sendPhoneWithValue(String phone) {
        request.post(phone);
    }

    @And("o website com o valor {string}")
    public void sendWebsiteWithValue(String website) {
        request.post(website);
    }

    @Then("o sistema deve retornar o status como {string}")
    public void validateStatusAdd(String statusCode) {
        request.post(statusCode);
        //statusCode.equals(201);
        //assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }
    @And("o id {string}")
    public void validateId(String id) {
        request.post(id);
        //id.equals(11);
    }

}