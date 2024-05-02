package StepDefinitions;

import Configs.ConfigInitial;
import Pages.ConsultPageAlbum;
import groovy.json.JsonException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.json.JSONException;
//import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.text.ParseException;

public class ConsultAlbum {
    String url;
    WebDriver driver;
    ConsultPageAlbum consultPageAlbum;
    ConfigInitial configInitial;

    @Before
    public void setUpWebDriver() {
        configInitial = new ConfigInitial();
        url = configInitial.getUrlApplication("urlSite");
        //System.setProperty("webdriver.chrome.driver", configInitial.getDriverPath());
        System.setProperty("webdriver.gecko.driver", "\\drivers\\geckodriver.exe");
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Given("que acesse o site jsonplaceholder")
    public void accessJsonPlaceholderSite() {
        initializeDriver();
        driver.get("https://jsonplaceholder.typicode.com/");
    }

    @And("selecione o menu {string}")
    public void selectMenu(String menuButton) {
        consultPageAlbum = new ConsultPageAlbum(driver);
        consultPageAlbum.accessGuide(menuButton);
    }

    @When("acessar o link {string}")
    public void accessLink(String link) throws InterruptedException {
        consultPageAlbum.accessAlbum(link);
        Thread.sleep(5000);
    }

    @Then("o sistema apresenta o ID {string}")
    public void validateReturnedId(String string) throws JSONException, IOException, ParseException {
        consultPageAlbum.validateArrayJson();
    }

    @And("com o título {string}")
    public void validateReturnedTitle(String string) throws JSONException, IOException, ParseException {
        consultPageAlbum.validateArrayJson();
    }
    public void initializeDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
