package mk.ukim.finki.dp.RPNCalculator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents the program that the calculator stores.
 */
public class RPNCalculatorProgram {
    private static RPNCalculatorProgram instance;
    private static List<String> programSequence;

    private RPNCalculatorProgram() {
        programSequence = new ArrayList<String>();
    }

    public static synchronized RPNCalculatorProgram getInstance() {
        if (instance == null) {
            instance = new RPNCalculatorProgram();
        }
        return instance;
    }

    /**
     * Adds new character to the programSequence.
     * @param s the character to be added
     */
    public void addProgramChar(String s) {
        programSequence.add(s);
    }

    /**
     * Gets the programSequence that is saved.
     * @return the programSequence as String
     */
    public String getProgramSequence() {
        StringBuilder programSequenceBuilder = new StringBuilder();
        for (String s : programSequence) {
            programSequenceBuilder.append(s);
        }
        return programSequenceBuilder.toString();
    }

    /**
     * Resets the program sequence.
     */
    public void resetProgramSequence() {
        programSequence = new ArrayList<String>();
    }

    /**
     * Saves the program sequence.
     */
    public void saveProgramSequence() {
        if (programSequence.size() > 20) {
            programSequence = programSequence.subList(0, 20);
        }
    }

    /**
     * Deletes the las character of the programSequence.
     */
    public void deleteLastSequenceCharacter() {
        programSequence.remove(programSequence.size() - 1);
    }
}
