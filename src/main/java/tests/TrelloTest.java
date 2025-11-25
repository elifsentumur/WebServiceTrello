package tests;

import io.restassured.response.Response;
import org.junit.Test;
import pages.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TrelloTest {
    private BoardPage boardPage;
    private CardPage cardPage;
    private CardUpdatePage cardUpdatePage;
    private DeleteCardPage deleteCardPage;
    private DeleteBoardPage deleteBoardPage;
    private List<String> cardIds;
    private Random random;
    private Response createResponse, listsResponse, c1, c2, updateCardResponse, deleteBoardResponse;

    @Test
    public void trelloScenarioTest() {

        boardPage = new BoardPage();
        cardPage = new CardPage();
        cardUpdatePage = new CardUpdatePage();
        deleteCardPage = new DeleteCardPage();
        deleteBoardPage = new DeleteBoardPage();
        List<String> cardIds = new ArrayList<>();
        random = new Random();

        // 1) Board oluştur
        String boardName = "ElifBoard-Auto";
        createResponse = boardPage.createBoard(boardName);
        createResponse.then().statusCode(200);

        String boardId = createResponse.jsonPath().getString("id");
        System.out.println("Created Board ID: " + boardId);

        assertNotNull(boardId, "Board oluşturulamadı! ID null döndü.");
        System.out.println("Board ID = " + boardId);

        System.out.println("boardId ========= " + boardPage.getBoardLists(boardId));

        //  BOARD'IN DEFAULT LİSTESİNİ GETİR

        listsResponse = boardPage.getBoardLists(boardId);
        String listId = listsResponse.jsonPath().getString("[0].id"); // default ilk liste
        System.out.println("Default List ID: " + listId);

        // ️ LİSTEYE 2 KART EKLE
        c1 = cardPage.createCard(listId, "Kart A");
        c1.then().statusCode(200);

        cardIds.add(c1.jsonPath().getString("id"));

        c2 = cardPage.createCard(listId, "Kart B");
        c2.then().statusCode(200);
        cardIds.add(c2.jsonPath().getString("id"));

        System.out.println("Oluşturulan kartlar: " + cardIds);

        //  RANDOM BİR KART SEÇ

        String randomCardId = cardIds.get(random.nextInt(cardIds.size()));
        System.out.println("Güncellenecek random kart: " + randomCardId);


        updateCardResponse = cardUpdatePage.updateCard(randomCardId, "test-elif");
        updateCardResponse.then().statusCode(200);
        System.out.println("Güncelleme Sonucu:");
        System.out.println(updateCardResponse.asPrettyString());
        String updatedName = updateCardResponse.jsonPath().getString("name");
        if (updatedName.equals("test-elif")) {
            System.out.println(" Güncelleme başarılı: " + updatedName);
        } else {
            System.out.println(" Güncelleme başarısız: " + updatedName);
        }


   // Eklenen Card'lar silindi
        deleteCardPage.deleteCardsByIds(cardIds);

        deleteBoardResponse = deleteBoardPage.deleteBoardById(boardId);
        assertEquals(200, deleteBoardResponse.getStatusCode(), "Board silme işlemi başarısız!");
    }
}
//https://trello.com/w/usercalismaalani71145886/home board sılme