package components;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostsComponent {

    @Step("GET /posts")
    public static Response getPosts(HashMap<String, ?> paramsMap) {
        Response postsResponse = given()
                .params(paramsMap)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts");
        postsResponse
                .then()
                .assertThat()
                .statusCode(200);
        return postsResponse;
    }
}
