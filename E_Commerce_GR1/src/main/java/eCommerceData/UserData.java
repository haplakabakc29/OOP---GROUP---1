package eCommerceData;

// encapsulation 

import java.util.ArrayList;

public class UserData { // model
    private String username;
    private String password;
    private String street;
    private String city;
    private String province;

    // base / parent 
    public UserData(String username, String password, String street, String city, String province) {
        this.username = username;
        this.password = password;
        this.street   = street;
        this.city     = city;
        this.province = province;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getConfDisplayInfo() {
        return "Welcome, " + username + "!";
    }
    
    //service 
    private static final ArrayList<UserData> accounts = new ArrayList<>();
 
    public static void register(String username, String password, String street, String city, String province) {
        accounts.add(new UserData(username, password, street, city, province));
    }
 
    public static boolean usernameExists(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
 
    public static boolean isValidLogin(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
 

    public static UserData getAccount(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return accounts.get(i);
            }
        }
        return null;
    }
}
