package steps;

import components.CommentsComponent;
import io.qameta.allure.Step;
import models.CommentsResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentsSteps {

    @Step("Get comments by postId")
    public List<CommentsResponse> getCommentsByPostId(int postId) {
        HashMap<String, Integer> paramsMap = new HashMap<>();
        paramsMap.put("postId", postId);
        List<CommentsResponse> commentsResponse = Arrays.asList(CommentsComponent.getComments(paramsMap).getBody().as(CommentsResponse[].class));
        assertTrue(commentsResponse.size() > 0, "No comments found with postId = " + postId);
        return commentsResponse;
    }

    @Step("Check email in comments for post id by regex")
    public void checkEmailInCommentsForPostIdByRegex(ArrayList<Integer> postsId, String regex) {
        postsId.forEach(id -> getCommentsByPostId(id).forEach(comment -> assertTrue(comment.getEmail().matches(regex),
                "Comment id = " + comment.getId() + " Email didn't match = " + comment.getEmail())));
    }
}
