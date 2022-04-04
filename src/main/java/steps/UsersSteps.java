package steps;

import components.UsersComponent;
import io.qameta.allure.Step;
import models.UsersResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsersSteps {

    @Step("Get user by username")
    public List<UsersResponse> getUserByUsername(String userName) {
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("username", userName);
        List<UsersResponse> usersResponse = Arrays.asList(UsersComponent.getUsers(paramsMap).getBody().as(UsersResponse[].class));
        assertTrue(usersResponse.size() > 0, "No user found with username = " + userName);
        assertTrue(usersResponse.size() < 2, "Two or more user's found with username = " + userName);
        return usersResponse;
    }

    @Step("Get user Id by username")
    public int getUserIdByUsername(String userName) {
        List<UsersResponse> usersResponse = getUserByUsername(userName);
        return usersResponse.get(0).getId();
    }
}
