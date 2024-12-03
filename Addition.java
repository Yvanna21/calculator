package Calculator;

public class Addition extends Operation{
    public Addition(double operand1, double operand2){
        super(operand1, operand2);
    }

    @Override
    protected double applyOperation() {
        return operand1+operand2;    
    }
    
}
