package mk.ukim.finki.dp.RPNCalculator.mathoperations;

/**
 * Implementation for the arcTangent operation.
 */
public class ArctangentOperationImpl implements MathTrigonometricOperation {
    @Override
    public Double calculate(Double operand) {
        return Math.atan(operand);
    }
}
