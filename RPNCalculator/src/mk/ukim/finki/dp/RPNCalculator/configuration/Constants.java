package mk.ukim.finki.dp.RPNCalculator.configuration;

import mk.ukim.finki.dp.RPNCalculator.main.R;

/**
 * Class for constant used to configure the calculator.
 */
public class Constants {
    public static final int STORAGE_REGISTERS_SIZE = 10;
    public static final String SAVED_STACK_VALUES_KEY = "stackValues";
    public static final String SAVED_TEXT_DISPLAY_VALUE = "txtDisplayValues";
    public static final String SAVED_UNDO_STACK_SIZE_KEY = "undoStackSize";
    public static final String SAVED_REDO_STACK_SIZE_KEY = "redoStackSize";
    public static final String SAVED_UNDO_STACK_ID_KEY = "undoStackId";
    public static final String SAVED_REDO_STACK_ID_KEY = "redoStackId";

    public static final String EMPTY_STRING = "";

    public static final String DECIMAL_ZERO = "0.0";

    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String FIVE = "5";
    public static final String SIX = "6";
    public static final String SEVEN = "7";
    public static final String EIGHT = "8";
    public static final String NINE = "9";

    public static final String PLUS = " + ";
    public static final String MINUS = " - ";
    public static final String SLASH = " / ";
    public static final String ASTERISK = " * ";
    public static final String DECIMAL_POINT = ".";

    public static final String OPERATOR_MINUS = "-";

    public static final String STATE_DEFAULT = "DEFAULT";
    public static final String STATE_PROGRAM = "PRGM";
    public static final String STATE_STORE = "STO";
    public static final String STATE_RECALL = "RCL";
    public static final String INV = "INV";
    public static final String DEG = "DEG";
    public static final String RAD = "RAD";


    public static final int TEXT_VIEW_DISPLAY_VALUE = R.id.txtDisplayValue;

    public static final int TEXT_VIEW_DISPLAY_STACK_1 = R.id.txtDisplayStack1;
    public static final int TEXT_VIEW_DISPLAY_STACK_2 = R.id.txtDisplayStack2;
    public static final int TEXT_VIEW_DISPLAY_STACK_3 = R.id.txtDisplayStack3;
    public static final int TEXT_VIEW_DISPLAY_STACK_4 = R.id.txtDisplayStack4;

    public static final int TEXT_VIEW_DISPLAY_STATE = R.id.txtDisplayState;
    public static final int TEXT_VIEW_DISPLAY_INV = R.id.txtDisplayInv;
    public static final int TEXT_VIEW_DISPLAY_DEG_RAD = R.id.txtDisplayDegRad;

    public static final int BUTTON_NUMBER_0 = R.id.button0;
    public static final int BUTTON_NUMBER_1 = R.id.button1;
    public static final int BUTTON_NUMBER_2 = R.id.button2;
    public static final int BUTTON_NUMBER_3 = R.id.button3;
    public static final int BUTTON_NUMBER_4 = R.id.button4;
    public static final int BUTTON_NUMBER_5 = R.id.button5;
    public static final int BUTTON_NUMBER_6 = R.id.button6;
    public static final int BUTTON_NUMBER_7 = R.id.button7;
    public static final int BUTTON_NUMBER_8 = R.id.button8;
    public static final int BUTTON_NUMBER_9 = R.id.button9;

    public static final int BUTTON_DECIMAL_POINT = R.id.buttonDecimalPoint;

    public static final int BUTTON_COMMAND_ENTER = R.id.buttonEnter;
    public static final int BUTTON_COMMAND_ADD = R.id.buttonAdd;
    public static final int BUTTON_COMMAND_SUBTRACT = R.id.buttonSubtract;
    public static final int BUTTON_COMMAND_MULTIPLY = R.id.buttonMultiply;
    public static final int BUTTON_COMMAND_DIVIDE = R.id.buttonDivide;

    public static final int BUTTON_COMMAND_CHANGE_SIGN = R.id.buttonChangeSign;
    public static final int BUTTON_COMMAND_BACK = R.id.buttonBack;
    public static final int BUTTON_COMMAND_DROP = R.id.buttonDrop;
    public static final int BUTTON_COMMAND_SWAP = R.id.buttonSwap;
    public static final int BUTTON_COMMAND_REDO = R.id.buttonRedo;
    public static final int BUTTON_COMMAND_UNDO = R.id.buttonUndo;
    public static final int BUTTON_COMMAND_RECALL = R.id.buttonRecall;
    public static final int BUTTON_COMMAND_STORE = R.id.buttonStore;
    public static final int BUTTON_COMMAND_EXECUTE = R.id.buttonExecute;
    public static final int BUTTON_COMMAND_PROGRAM = R.id.buttonProgram;

    public static final int BUTTON_COMMAND_SINE = R.id.buttonSine;
    public static final int BUTTON_COMMAND_COSINE = R.id.buttonCosine;
    public static final int BUTTON_COMMAND_TANGENT = R.id.buttonTangent;

    public static final int BUTTON_COMMAND_DEG = R.id.buttonDeg;
    public static final int BUTTON_COMMAND_RAD = R.id.buttonRad;
    public static final int BUTTON_COMMAND_INVERSE = R.id.buttonInverse;

    public static final int BUTTONS[] = {
            BUTTON_NUMBER_0,
            BUTTON_NUMBER_1,
            BUTTON_NUMBER_2,
            BUTTON_NUMBER_3,
            BUTTON_NUMBER_4,
            BUTTON_NUMBER_5,
            BUTTON_NUMBER_6,
            BUTTON_NUMBER_7,
            BUTTON_NUMBER_8,
            BUTTON_NUMBER_9,
            BUTTON_DECIMAL_POINT,
            BUTTON_COMMAND_ENTER,
            BUTTON_COMMAND_ADD,
            BUTTON_COMMAND_SUBTRACT,
            BUTTON_COMMAND_MULTIPLY,
            BUTTON_COMMAND_DIVIDE,
            BUTTON_COMMAND_CHANGE_SIGN,
            BUTTON_COMMAND_BACK,
            BUTTON_COMMAND_DROP,
            BUTTON_COMMAND_SWAP,
            BUTTON_COMMAND_REDO,
            BUTTON_COMMAND_UNDO,
            BUTTON_COMMAND_RECALL,
            BUTTON_COMMAND_STORE,
            BUTTON_COMMAND_EXECUTE,
            BUTTON_COMMAND_PROGRAM,
            BUTTON_COMMAND_SINE,
            BUTTON_COMMAND_COSINE,
            BUTTON_COMMAND_TANGENT,
            BUTTON_COMMAND_INVERSE,
            BUTTON_COMMAND_DEG,
            BUTTON_COMMAND_RAD
    };

    public static final int TEXT_VIEWS_STACK[] = {
            TEXT_VIEW_DISPLAY_STACK_1,
            TEXT_VIEW_DISPLAY_STACK_2,
            TEXT_VIEW_DISPLAY_STACK_3,
            TEXT_VIEW_DISPLAY_STACK_4
    };

    public static final int TEXT_VIEWS_INFO[] = {
            TEXT_VIEW_DISPLAY_STATE,
            TEXT_VIEW_DISPLAY_INV,
            TEXT_VIEW_DISPLAY_DEG_RAD
    };

    public static final int DISPLAY_STATE_INDEX = 0;
    public static final int DISPLAY_INV_INDEX = 1;
    public static final int DISPLAY_DEG_RAD_INDEX = 2;
}
