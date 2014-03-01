package mk.ukim.finki.dp.RPNCalculator.mathoperations;

/**
 * Implementation for the arcsine operation.
 */
public class ArcsineOperationImpl implements MathTrigonometricOperation {
    @Override
    public Double calculate(Double operand) {
        return Math.asin(operand);
    }
}
