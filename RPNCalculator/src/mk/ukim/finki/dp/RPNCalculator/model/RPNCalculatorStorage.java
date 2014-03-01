package mk.ukim.finki.dp.RPNCalculator.model;

import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;

/**
 * Class for the calculator's storage registers.
 */
public class RPNCalculatorStorage {
    private static RPNCalculatorStorage instance;
    private static double storageRegisters[];

    private RPNCalculatorStorage() {
        storageRegisters = new double[Constants.STORAGE_REGISTERS_SIZE];
    }

    public static synchronized RPNCalculatorStorage getInstance() {
        if (instance == null) {
            instance = new RPNCalculatorStorage();
        }
        return instance;
    }

    /**
     * Adds value to certain register.
     * @param value the value to be added
     * @param index the number of the register
     */
    public void setRegisterValue(double value, int index) {
        storageRegisters[index] = value;
    }

    /**
     * Gets value from the register given with its position.
     * @param index the position of the register
     * @return value of the register in double
     */
    public double getRegisterValue(int index) {
        double result = storageRegisters[index];
        storageRegisters[index] = 0;
        return result;
    }
}
