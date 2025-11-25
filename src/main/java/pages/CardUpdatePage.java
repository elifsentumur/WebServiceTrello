package pages;

import base.BaseApi;
import io.restassured.response.Response;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class CardUpdatePage extends BaseApi {

    public CardUpdatePage() {
        super();
    }

    private final String updateCardEndpoint = "/1/cards/";

    public Response updateRandomCard(List<String> cardIds, String newName) {
        Random random = new Random();
        String randomCardId = cardIds.get(random.nextInt(cardIds.size()));

        return given()
                .spec(reqSpec)
                .queryParam("name", newName)
                .when()
                .put(updateCardEndpoint + randomCardId);
    }


    public Response updateCard(String cardId, String newName) {
        return given()
                .spec(reqSpec)
                .queryParam("name", newName)
                .when()
                .put(updateCardEndpoint + cardId);
    }
}
