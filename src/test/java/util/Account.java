package util;

public class Account {

    private String login;
    private String domain;
    private String password;

    public Account(String[] data) {
        login = data[0];
        domain = data[1];
        password = data[2];
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
