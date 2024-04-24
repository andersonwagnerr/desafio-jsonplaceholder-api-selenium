package pages;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ConsultaTelaPage {
    protected WebDriver driver;

    private By BotaoMenuGuide = By.xpath("/html/body/header/nav/ul/li[1]/a");
    private By LinkAlbumPhotos = By.xpath("/html/body/div/main/ul/li[2]/a");
    private By telaValoresJson = By.xpath("/html/body/pre");

    public ConsultaTelaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        if (!driver.getTitle().equals("JSONPlaceholder - Free Fake REST API")) {
            throw new IllegalStateException("Está não é a pagina JSONPlaceholder. A pagina corrente é " + driver.getCurrentUrl());
        }
    }

    public void clicarBotao (String botao) {
        WebDriverWait esperaElemento = new WebDriverWait(driver, 60);
        if (botao.equals("Guide")) {
            esperaElemento.until(ExpectedConditions.visibilityOfElementLocated(BotaoMenuGuide));
            driver.findElement(BotaoMenuGuide).isDisplayed();
            driver.findElement(BotaoMenuGuide).click();
        } else if (botao.equals("/albums/1/photos")) {
            esperaElemento.until(ExpectedConditions.visibilityOfElementLocated(LinkAlbumPhotos));
            driver.findElement(LinkAlbumPhotos).isDisplayed();
            driver.findElement(LinkAlbumPhotos).click();
        } else {
            System.out.println("botão não encontrado");
        }
    }

    public void validaArrayJson() throws IOException, ParseException, JSONException {

        JSONParser parser = new JSONParser();
        FileWriter escreva = null;

//        Cria arquivo
        java.util.List<WebElement> lista = driver.findElements(telaValoresJson);
        for (WebElement validaElemento : lista) {
            String txt = validaElemento.getText();
            try {
                escreva = new FileWriter("saida.json");
                //Escreve no arquivo conteudo do Objeto JSON
                escreva.write(txt);
                escreva.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Imprimne na Tela o Objeto JSON para vizualização
//        System.out.println(txt);


        }
    }

}
