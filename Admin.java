public class Admin {
    String userName,password;
    protected static Admin admin=new Admin("1234","123");

    private Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
