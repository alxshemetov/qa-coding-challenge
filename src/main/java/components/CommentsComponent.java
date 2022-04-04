package components;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import specs.RequestSpec;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CommentsComponent {

    @Step("GET /comments")
    public static Response getComments(HashMap<String, ?> paramsMap) {
        Response commentsResponse = given()
                .spec(RequestSpec.getRequestSpec())
                .params(paramsMap)
                .when()
                .get("/comments");
        commentsResponse
                .then()
                .assertThat()
                .statusCode(200);
        return commentsResponse;
    }
}
