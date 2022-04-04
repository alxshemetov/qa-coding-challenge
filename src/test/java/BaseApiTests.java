import steps.CommentsSteps;
import steps.PostsSteps;
import steps.UsersSteps;

public class BaseApiTests {

    protected UsersSteps usersSteps = new UsersSteps();
    protected PostsSteps postsSteps = new PostsSteps();
    protected CommentsSteps commentsSteps = new CommentsSteps();
}