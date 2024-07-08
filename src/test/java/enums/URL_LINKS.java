package enums;

public enum URL_LINKS {
    LOGIN_URL("https://test.urbanicfarm.com/auth/login");

    private final String getLink;

    URL_LINKS(String getLink) {
        this.getLink = getLink;
    }

    public String getLink() {

        return getLink;
    }

}
