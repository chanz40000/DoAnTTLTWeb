package controller.testLog;

public class UserDAO extends absDAO<User>{
    @Override
    public int update(User model){
        super.update(model);
        return 1;
    }

}

