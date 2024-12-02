package Calculator;

public class Puissance extends Operation{
    public Puissance(double operand1, double operand2){
        super(operand1, operand2);
    }

    @Override
    public double applyOperation() {
        return Math.pow(operand1, operand2) ;    
    }
}
