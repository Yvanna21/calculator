package Calculator;

public class SquareRoot extends Operation{
    public SquareRoot(double operand1){
        super(operand1, 0);
    }

    @Override
    public double applyOperation() {
        return Math.sqrt(operand1) ;    
    }
}
