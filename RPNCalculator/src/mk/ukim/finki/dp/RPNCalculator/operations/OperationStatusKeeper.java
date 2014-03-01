package mk.ukim.finki.dp.RPNCalculator.operations;

/**
 * Class that holds the status of the current operation.
 */
public class OperationStatusKeeper {
    private static OperationStatusKeeper instance;
    private static boolean operationExecuted;

    private OperationStatusKeeper(){
        operationExecuted = false;
    }

    public static synchronized OperationStatusKeeper getInstance(){
        if(instance==null){
            instance = new OperationStatusKeeper();
        }
        return instance;
    }

    public boolean isOperationExecuted(){
        return operationExecuted;
    }

    public void setOperationExecuted(boolean executed){
        operationExecuted = executed;
    }
}
