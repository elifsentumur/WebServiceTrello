package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.io.InputStream;
import java.util.Properties;


public class BaseApi {
    protected String key;
    protected String token;

    protected RequestSpecification reqSpec;

    public BaseApi() {
        loadProperties();

        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com")
                .addQueryParam("key", key)
                .addQueryParam("token", token)
                .addHeader("Accept", "application/json")
                .build();
    }

    private void loadProperties() {
        try {
            Properties properties = new Properties();
            InputStream inStream = getClass().getClassLoader().getResourceAsStream("config.properties");

            if (inStream == null) {
                throw new RuntimeException("config.properties okunamadı!");
            }

            properties.load(inStream);

            this.key = properties.getProperty("trelloKey");
            this.token = properties.getProperty("trelloToken");

        } catch ( Exception e ) {
            throw new RuntimeException("config.properties yüklenirken hata oluştu!", e);
        }

    }
}