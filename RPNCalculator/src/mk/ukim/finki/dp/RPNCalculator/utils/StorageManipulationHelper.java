package mk.ukim.finki.dp.RPNCalculator.utils;

import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStorage;

/**
 * Class that helps with the manipulation of the storage registers.
 */
public class StorageManipulationHelper {
    public static RPNCalculatorStorage storage = RPNCalculatorStorage.getInstance();

    /**
     * Sets value to register given with index.
     *
     * @param value the value to be saved
     * @param index the index of the register
     */
    public static void setValueToRegister(double value, int index) {
        storage.setRegisterValue(value, index);
    }

    /**
     * Gets saved value from the register given with index.
     *
     * @param index the index of the register
     * @return the saved value as double
     */
    public static double getValueFromRegister(int index) {
        return storage.getRegisterValue(index);
    }
}
