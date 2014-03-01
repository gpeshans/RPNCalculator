package mk.ukim.finki.dp.RPNCalculator.model;

import mk.ukim.finki.dp.RPNCalculator.states.StateType;

/**
 * Class that holds the active state of the calculator.
 */
public class RPNCalculatorState {
    private static RPNCalculatorState instance;
    private static StateType activeState;

    private RPNCalculatorState() {
        activeState = StateType.DEFAULT;
    }

    public static synchronized RPNCalculatorState getInstance() {
        if (instance == null) {
            instance = new RPNCalculatorState();
        }
        return instance;
    }

    public StateType getActiveState() {
        return activeState;
    }

    public void setActiveState(StateType state) {
        activeState = state;
    }
}
