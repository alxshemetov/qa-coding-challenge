package steps;

import components.PostsComponent;
import io.qameta.allure.Step;
import models.PostsResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostsSteps {

    @Step("Get posts by userId")
    public List<PostsResponse> getPostsByUserId(int userId) {
        HashMap<String, Integer> paramsMap = new HashMap<>();
        paramsMap.put("userId", userId);
        List<PostsResponse> postsResponse = Arrays.asList(PostsComponent.getPosts(paramsMap).getBody().as(PostsResponse[].class));
        assertTrue(postsResponse.size() > 0, "No posts found with userId = " + userId);
        return postsResponse;
    }

    @Step("Get posts Id by userId")
    public ArrayList<Integer> getPostsIdByUserId(int userId) {
        List<PostsResponse> postsResponse = getPostsByUserId(userId);
        ArrayList<Integer> postsId = new ArrayList<>();
        postsResponse.forEach(post -> postsId.add(post.getId()));
        return postsId;
    }
}
