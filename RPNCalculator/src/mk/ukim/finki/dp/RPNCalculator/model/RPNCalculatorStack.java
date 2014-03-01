package mk.ukim.finki.dp.RPNCalculator.model;

import java.util.Stack;

/**
 * Class that represents/stores the calculator's working rpnStack.
 * Also it keeps the calculator's UNDO and REDO stacks.
 */
public class RPNCalculatorStack {
    private static RPNCalculatorStack instance;
    private static Stack<Double> rpnStack;
    private static Stack<Stack<Double>> undoStack;
    private static Stack<Stack<Double>> redoStack;

    private RPNCalculatorStack() {
        rpnStack = new Stack<Double>();
        undoStack = new Stack<Stack<Double>>();
        redoStack = new Stack<Stack<Double>>();
    }

    public static synchronized RPNCalculatorStack getInstance() {
        if (instance == null) {
            instance = new RPNCalculatorStack();
        }
        return instance;
    }

    /**
     * Pushes value to the rpnStack.
     *
     * @param value the value to be pushed
     */
    public void pushToStack(Double value) {
        undoStack.push((Stack<Double>) rpnStack.clone());
        rpnStack.push(value);
    }

    /**
     * Pops value to the rpnStack.
     *
     * @return the value that is popped
     */
    public Double popFromStack() {
        undoStack.push((Stack<Double>) rpnStack.clone());
        return rpnStack.pop();
    }

    public Stack<Stack<Double>> getUndoStack() {
        return undoStack;
    }

    public Stack<Stack<Double>> getRedoStack() {
        return redoStack;
    }

    public Stack<Double> getRpnStack() {
        return rpnStack;
    }

    /**
     * Executes the UNDO operation.
     */
    public void undo() {
        redoStack.push((Stack<Double>) rpnStack.clone());
        if (!undoStack.isEmpty()) {
            rpnStack = undoStack.pop();
        }
    }

    /**
     * Executes the REDO operation.
     */
    public void redo() {
        undoStack.push((Stack<Double>) rpnStack.clone());
        if (!redoStack.isEmpty()) {
            rpnStack = redoStack.pop();
        }
    }

    /**
     * Checks if the main stack is empty or not.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isStackEmpty() {
        return rpnStack.isEmpty();
    }
}
