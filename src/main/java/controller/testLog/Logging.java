package controller.testLog;

public class Logging {
    public static void update(IModel model){
        System.out.println("Table -->"+model.getTable()+
        "\n beforeData: " + model.beforeData()
        +"\n afterData: "+ model.afterData());
    }
}
