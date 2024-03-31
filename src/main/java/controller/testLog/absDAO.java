package controller.testLog;

public abstract class absDAO<T extends IModel> implements IDAO<T>{
    public int update(T model) {
        Logging.update(model);
        return 1;
    }
}
