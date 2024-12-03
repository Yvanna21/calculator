package Calculator;

public class Division extends Operation{
    public Division(double operand1, double operand2){
        super(operand1, operand2);
    }

    @Override
    protected double applyOperation() {
        return operand1/operand2;    
    }
}
