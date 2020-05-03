public class User {
    private int userId;
    private String userLogin;
    private String userPassword;

    public User (int userId, String userLogin, String userPassword) {
        setUserId(userId);
        setUserLogin(userLogin);
        setUserPassword(userPassword);
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserId: " + this.userId + "UserLogin: " + this.userLogin + "UserPassword: " + this.userPassword;
    }

}
