package Configs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigInitial {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/Config.properties";

    public ConfigInitial() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Arquivo Config.properties não foi encontrado em " + propertyFilePath);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo Config.properties: " + e.getMessage());
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPathFirefox");
        if (driverPath != null) {
            return driverPath;
        } else {
            throw new RuntimeException("O caminho do driver não foi encontrado no arquivo Config.properties");
        }
    }

    public String getUrlApplication(String url) {
        if ("urlSite".equals(url)) {
            return properties.getProperty("urlSite");
        } else {
            throw new RuntimeException("A URL da aplicação não foi encontrada no arquivo Config.properties");
        }
    }
}
