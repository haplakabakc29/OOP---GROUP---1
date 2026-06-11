package eCommerceData;

// encapsulation 
public class UserData { // model
    private String username;
    private String password;
    String street;
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
   
    // viewprof
    public String getFullAddress() {
        return street + "\n" + city + ", " + province;
    }
    
}
