package mk.ukim.finki.dp.RPNCalculator.mathoperations;

/**
 * Implementation for the tangent operation.
 */
public class TangentOperationImpl implements MathTrigonometricOperation {
    @Override
    public Double calculate(Double operand) {
        return Math.tan(operand);
    }
}
