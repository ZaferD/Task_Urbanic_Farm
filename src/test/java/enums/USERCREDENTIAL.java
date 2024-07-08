package enums;

public enum USERCREDENTIAL {
    USERSELLER("seller_urban@mailsac.com","VHt*zzt*wQNu6XS");

    private final String getUsername;
    private final String getPassword;
    USERCREDENTIAL(String username, String password) {
        this.getUsername = username;
        this.getPassword = password;
    }
    public String getUsername(){
        return getUsername;
    }
    public String getPassword(){
        return getPassword;
    }
}
