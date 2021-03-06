package components;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import specs.RequestSpec;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UsersComponent {

    @Step("GET /users")
    public static Response getUsers(HashMap<String, ?> paramsMap) {
        Response usersResponse = given()
                .spec(RequestSpec.getRequestSpec())
                .params(paramsMap)
                .when()
                .get("/users");
        usersResponse
                .then()
                .assertThat()
                .statusCode(200);
        return usersResponse;
    }
}
