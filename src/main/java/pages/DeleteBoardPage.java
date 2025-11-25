package pages;

import base.BaseApi;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBoardPage extends BaseApi {
    public DeleteBoardPage() {
        super();
    }
    private final String deleteBoardEndpoint = "/1/boards/";

    public Response deleteBoardById(String boardId) {
        Response response = given()
                .spec(reqSpec)
                .delete(deleteBoardEndpoint + boardId);

        if (response.getStatusCode() == 200) {
            System.out.println("Board silindi: " + boardId);
        } else {
            System.out.println(" Board silme başarısız: " + boardId);
            System.out.println(response.asPrettyString());
        }

        return response;
    }
}