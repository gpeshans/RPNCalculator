package mk.ukim.finki.dp.RPNCalculator.mathoperations;

/**
 * Implementation for the arccosine operation.
 */
public class ArccosineOperationImpl implements MathTrigonometricOperation {
    @Override
    public Double calculate(Double operand) {
        return Math.acos(operand);
    }
}
