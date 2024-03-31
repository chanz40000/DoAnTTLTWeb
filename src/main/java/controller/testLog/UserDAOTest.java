package controller.testLog;

public class UserDAOTest {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user = new User();
        userDAO.update(user);
    }
}
