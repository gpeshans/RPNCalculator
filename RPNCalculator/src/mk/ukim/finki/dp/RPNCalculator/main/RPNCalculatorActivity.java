package mk.ukim.finki.dp.RPNCalculator.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.commands.ButtonClickListenersManager;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.utils.DisplayValueHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Main class.
 */
public class RPNCalculatorActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        RPNCalculatorStack stack = RPNCalculatorStack.getInstance();
        ButtonClickListenersManager buttonClickListenersManager = new ButtonClickListenersManager(this);
        buttonClickListenersManager.setButtonsClickListeners();

        // Code for retrieving the saved calculator state on screen rotate.
        // The Android initializes all data on screen rotate.
        if (savedInstanceState != null) {
            double savedStackValues[] = savedInstanceState.getDoubleArray(Constants.SAVED_STACK_VALUES_KEY);
            stack.getRpnStack().removeAllElements();
            stack.getUndoStack().removeAllElements();
            stack.getRedoStack().removeAllElements();

            for (int i = 0; i < savedStackValues.length; i++) {
                stack.getRpnStack().push(savedStackValues[i]);
            }

            int numUndoStackSize = savedInstanceState.getInt(Constants.SAVED_UNDO_STACK_SIZE_KEY);
            int numRedoStackSize = savedInstanceState.getInt(Constants.SAVED_REDO_STACK_SIZE_KEY);

            double currentUndoStackArray[] = null;
            for (int i = 0; i < numUndoStackSize; i++) {
                currentUndoStackArray = savedInstanceState.getDoubleArray(Constants.SAVED_UNDO_STACK_ID_KEY + i);
                Stack<Double> currentUndoStack = new Stack<Double>();
                for (int j = 0; j < currentUndoStackArray.length; j++) {
                    currentUndoStack.push(currentUndoStackArray[j]);
                }
                stack.getUndoStack().push(currentUndoStack);
            }

            double currentRedoStackArray[] = null;
            for (int i = 0; i < numRedoStackSize; i++) {
                currentRedoStackArray = savedInstanceState.getDoubleArray(Constants.SAVED_REDO_STACK_ID_KEY + i);
                Stack<Double> currentRedoStack = new Stack<Double>();
                for (int j = 0; j < currentRedoStackArray.length; j++) {
                    currentRedoStack.push(currentRedoStackArray[j]);
                }
                stack.getUndoStack().push(currentRedoStack);
            }

            TextView txtDisplayValue = (TextView) findViewById(Constants.TEXT_VIEW_DISPLAY_VALUE);
            String txtDisplayValueText = savedInstanceState.getString(Constants.SAVED_TEXT_DISPLAY_VALUE);
            DisplayValueHelper.setDisplayValue(txtDisplayValue, txtDisplayValueText);
            DisplayValueHelper.initializeStackTxtValues(this);
            DisplayValueHelper.displayStackValues(stack.getRpnStack());
        } else {
            DisplayValueHelper.initializeStackTxtValues(this);
        }
        DisplayValueHelper.initializeInfoTxtValues(this);
    }
    /**
     * Called before screen rotate so that the state of the app can be saved.
     * @param outState the bundle (Map) that stores the program state.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        RPNCalculatorStack stack = RPNCalculatorStack.getInstance();
        double rpnStackValues[] = new double[stack.getRpnStack().size()];

        for (int i = 0; i < stack.getRpnStack().size(); i++) {
            rpnStackValues[i] = stack.getRpnStack().get(i);
        }

        double currentStack[] = null;

        for (int i = 0; i < stack.getUndoStack().size(); i++) {
            currentStack = new double[stack.getUndoStack().get(i).size()];
            for (int j = 0; j < stack.getUndoStack().get(i).size(); j++) {
                currentStack[j] = stack.getUndoStack().get(i).get(j);
            }
            outState.putDoubleArray(Constants.SAVED_UNDO_STACK_ID_KEY + i, currentStack);
        }

        for (int i = 0; i < stack.getRedoStack().size(); i++) {
            currentStack = new double[stack.getRedoStack().get(i).size()];
            for (int j = 0; j < stack.getRedoStack().get(i).size(); j++) {
                currentStack[j] = stack.getRedoStack().get(i).get(j);
            }
            outState.putDoubleArray(Constants.SAVED_REDO_STACK_ID_KEY + i, currentStack);
        }

        TextView txtDisplayValue = (TextView) findViewById(Constants.TEXT_VIEW_DISPLAY_VALUE);

        outState.putInt(Constants.SAVED_UNDO_STACK_SIZE_KEY, stack.getUndoStack().size());
        outState.putInt(Constants.SAVED_REDO_STACK_SIZE_KEY, stack.getRedoStack().size());
        outState.putString(Constants.SAVED_TEXT_DISPLAY_VALUE, txtDisplayValue.getText().toString());
        outState.putDoubleArray(Constants.SAVED_STACK_VALUES_KEY, rpnStackValues);
    }
}
