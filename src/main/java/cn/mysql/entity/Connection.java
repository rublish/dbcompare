package cn.mysql.entity;

public class Connection {
    private String host;
    private String DBName;
    private String userName;
    private String passWord;

    public Connection(String host, String DBName, String userName, String passWord) {
        this.host = host;
        this.DBName = DBName;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
