package components;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import specs.RequestSpec;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostsComponent {

    @Step("GET /posts")
    public static Response getPosts(HashMap<String, ?> paramsMap) {
        Response postsResponse = given()
                .spec(RequestSpec.getRequestSpec())
                .params(paramsMap)
                .when()
                .get("/posts");
        postsResponse
                .then()
                .assertThat()
                .statusCode(200);
        return postsResponse;
    }
}
