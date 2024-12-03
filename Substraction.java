package Calculator;

public class Substraction  extends Operation{
    public Substraction(double operand1, double operand2){
        super(operand1, operand2);
    }

    @Override
    protected double applyOperation() {
        return operand1-operand2;    
    }
}
