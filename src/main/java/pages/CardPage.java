package pages;

import base.BaseApi;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class CardPage  extends BaseApi {
    public CardPage() {
        super();
    }
    private final String createCardEndpoint = "1/cards";

    public Response createCard(String listId, String cardName) {
        return given()
                .spec(reqSpec)
                .queryParam("idList", listId)
                .queryParam("name", cardName)
                .when()
                .post(createCardEndpoint);
    }
}
