package blog.forms;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreatePostForm {
    @NotNull
    @Size(min= 5, max=150, message = "Post title size should be in the range [2...30]")/*We have field with these parameters,
    with these requirements, the message is not required to be typed, but in other case message is default*/
    private String title;

    @NotNull /*We have field with these parameters*/
    @Size(min = 5, max=460)
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
