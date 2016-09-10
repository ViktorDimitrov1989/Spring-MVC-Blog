package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
    @NotNull
    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")/*We have field with these parameters,
    with these requirements, the message is not required to be typed, but in other case message is default*/
    private String username;

    @NotNull /*We have field with these parameters*/
    @Size(min=1, max=50)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
