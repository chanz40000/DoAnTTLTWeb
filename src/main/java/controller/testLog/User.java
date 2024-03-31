package controller.testLog;

public class User implements IModel{


    @Override
    public String getTable() {
        return "USER";
    }

    @Override
    public String beforeData() {
        return "BEFORE";
    }

    @Override
    public String afterData() {
        return "AFTER";
    }
}
