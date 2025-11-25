package pages;


import base.BaseApi;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class DeleteCardPage extends BaseApi {
    public DeleteCardPage() {
        super();
    }
   private final String deleteCardEndpoint = "/1/cards/";


    // Kart silme metodu
    public Response deleteCardById(String cardId) {
        Response response = given()
                .spec(reqSpec)
                .delete(deleteCardEndpoint + cardId);

        if(response.getStatusCode() == 200){
            System.out.println("✅ Kart silindi: " + cardId);
        } else {
            System.out.println("❌ Kart silme başarısız: " + cardId);
            System.out.println(response.asPrettyString());
        }

        return response;
    }

    // Çoklu kart silme
    public void deleteCardsByIds(List<String> cardIds) {
        for (String cardId : cardIds) {
            deleteCardById(cardId);
        }
    }
}