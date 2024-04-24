package Pages;

import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class ConsultPageAlbum {
    protected WebDriver driver;

    private final By buttonMenuGuide = By.xpath("//a[contains(text(),'Guide')]");
    private final By linkAlbumPhotos = By.xpath("//a[contains(text(),'/albums/1/photos')]");
    private final By valuesJson = By.className(".data");

    public ConsultPageAlbum(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        if (!driver.getTitle().equals("JSONPlaceholder - Free Fake REST API")) {
            throw new IllegalStateException("Esta não é a página da JSONPLACEHOLDER. A página correta é " + driver.getCurrentUrl());
        }
    }

    public void accessGuide(String button) {
        WebDriverWait waitForElement = new WebDriverWait(driver, 60);
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(buttonMenuGuide));
        driver.findElement(buttonMenuGuide).isDisplayed();
        driver.findElement(buttonMenuGuide).click();


//        if (button.equals("Guide")) {
//            waitForElement.until(ExpectedConditions.visibilityOfElementLocated(buttonMenuGuide));
//            driver.findElement(buttonMenuGuide).isDisplayed();
//            driver.findElement(buttonMenuGuide).click();
//        } else if (button.equals("/albums/1/photos")) {
//            waitForElement.until(ExpectedConditions.visibilityOfElementLocated(linkAlbumPhotos));
//            driver.findElement(linkAlbumPhotos).isDisplayed();
//            driver.findElement(linkAlbumPhotos).click();
//        } else {
//            System.out.println("botão não encontrado");
//        }
    }

    public void accessAlbum(String button) {
        WebDriverWait waitForElement = new WebDriverWait(driver, 60);
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(linkAlbumPhotos));
        driver.findElement(linkAlbumPhotos).isDisplayed();
        driver.findElement(linkAlbumPhotos).click();
    }
    public void validateArrayJson() throws IOException, ParseException, JSONException {

        JSONParser parser = new JSONParser();
        FileWriter writer;

        java.util.List<WebElement> listValues = driver.findElements(valuesJson);

        for (WebElement validateElement : listValues) {
            String txt = validateElement.getText();
            try {
                writer = new FileWriter("output.json");
                writer.write(txt);
                writer.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
