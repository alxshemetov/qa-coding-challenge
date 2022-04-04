import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CommentsTests extends BaseApiTests {

    @Test
    @DisplayName("Verify email in comments for user's posts")
    public void verifyEmailsInCommentsForUsersPosts() {
        //  Search for the user with username “Delphine”.
        int userId = usersSteps.getUserIdByUsername("Delphine");
        //  Use the details fetched to make a search for the posts written by the user.
        ArrayList<Integer> postsId = postsSteps.getPostsIdByUserId(userId);
        //  For each post, fetch the comments and validate if the emails in the comment section are in the proper format.
        commentsSteps.checkEmailInCommentsForPostIdByRegex(postsId, "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
}