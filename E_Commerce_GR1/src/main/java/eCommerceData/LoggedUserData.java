package eCommerceData;

// inheritance subclass
public class LoggedUserData extends UserData {

    private String memberType;

    public LoggedUserData(String username, String password, String street, String city, String province) {
        super(username, password, street, city, province);
        this.memberType = "Gold Member";
    }

    public String getMemberType() {
        return memberType;
    }

    public String getConfDisplayInfo() {
        return "Thankyou for Ordering " + getUsername();
    }
    
}