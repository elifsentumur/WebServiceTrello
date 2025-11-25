package pages;

import base.BaseApi;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BoardPage extends BaseApi {
    public BoardPage() {
        super();
    }
    private final String boardEndpoint = "/1/boards/";

    public Response createBoard(String boardName) {

        return given()
                .spec(reqSpec)
                .queryParam("name", boardName)
                .when()
                .post(boardEndpoint);
    }


    // Board'daki listeleri çekmek için method
    public Response getBoardLists(String boardId) {
        return given()
                .spec(reqSpec)
                .header("Accept", "application/json")
                .get(boardEndpoint + boardId + "/lists");
    }
}
