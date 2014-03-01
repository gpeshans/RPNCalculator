package mk.ukim.finki.dp.RPNCalculator.utils;

import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorProgram;

/**
 * Class that helps with the manipulation of the stored program sequence.
 */
public class ProgramManipulationHandler {
    public static RPNCalculatorProgram program = RPNCalculatorProgram.getInstance();

    /**
     * Adds character to the program sequence.
     * @param s the character to be added.
     */
    public static void addProgramCharacter(String s) {
        program.addProgramChar(s);
    }

    /**
     * Gets the saved program sequence.
     * @return program sequence as String
     */
    public static String getProgramSequence() {
        return program.getProgramSequence();
    }

    /**
     * Resets the program sequence.
     */
    public static void resetProgramSequence() {
        program.resetProgramSequence();
    }

    /**
     * Saves the program sequence.
     */
    public static void saveProgramSequence() {
        program.saveProgramSequence();
    }

    /**
     * Deletes the pprogram sequence.
     */
    public static void deleteLastSequenceCharacter(){
        program.deleteLastSequenceCharacter();
    }
}
