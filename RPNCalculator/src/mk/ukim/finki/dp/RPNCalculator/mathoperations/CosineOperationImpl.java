package mk.ukim.finki.dp.RPNCalculator.mathoperations;

/**
 * Implementation for the sine operation.
 */
public class CosineOperationImpl implements MathTrigonometricOperation {
    @Override
    public Double calculate(Double operand) {
        return Math.cos(operand);
    }
}
