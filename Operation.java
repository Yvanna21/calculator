package Calculator;

public abstract class Operation {
    protected double operand1;
    protected double operand2;
    public Operation(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
    protected abstract double applyOperation();

}
