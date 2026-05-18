package com.mycompany.viewprofile;

//inheritance subclass
public class loggedUser extends User {
    
    private String memberType;

    public loggedUser(String username, String password) {
        super(username, password);
        this.memberType = "Gold Member";
    }

    public String getMemberType() {
        return memberType;
    }

    public String getConfDisplayInfo() {
        return "Thankyou for Ordering " + getUsername();
    }
    

}