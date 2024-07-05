import java.util.ArrayList;

public class Admin {
    private String username ;
    private String password ;
    public ArrayList<Quiz> quizzes = new ArrayList<>();
    public Admin() {
        username = "Admin";
        password = "123";
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public void setPassword(String password){ this.password=password;}
    public void setUsername(String username){this.username=username;}
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}