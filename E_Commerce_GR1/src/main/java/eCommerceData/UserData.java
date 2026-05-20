package eCommerceData;

// encapsulation 
public class UserData {
    private String username;
    private String password;

    // base / parent 
    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    
    public String getConfDisplayInfo() {
        return "Welcome, " + username + "!";
    }
}