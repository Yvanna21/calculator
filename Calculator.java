package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private Operation operation;

    public void setOperation(Operation operation){
        this.operation=operation;
    }

    public double applyOperation(){
        if (operation==null) {
            throw new IllegalStateException("Aucune opération définie !");
        }
        return operation.applyOperation();
    }

    public static void printMenu(){
        System.out.println("\n --- Calculator Menu --- \n");
        System.out.println("Choose an operation");
        System.out.println("1. Addition");
        System.out.println("2. Substraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Puissance");
        System.out.println("6. Square Root");
        System.out.print("Enter the operation name : ");
        
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Calculator calculator=new Calculator();
        boolean on=true;
        while (on) {
            scanner.nextLine();

            printMenu();
            String typeOperation=scanner.nextLine().toLowerCase();

            double operand1=0;
            double operand2=0;

            try {
                if (!typeOperation.equals("square root")) {
                    System.out.print("Enter the first operand : ");
                    operand1=scanner.nextDouble();
                }
                if (!typeOperation.equals("square root")) {
                    System.out.print("Enter the second operand : ");
                    operand2=scanner.nextDouble();
                }else{
                    System.out.print("Enter the number : ");
                    operand1=scanner.nextDouble();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error, please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            switch (typeOperation) {
                case "addition":
                    calculator.setOperation(new Addition(operand1,operand2));
                    break;
                case "substraction":
                    calculator.setOperation(new Substraction(operand1,operand2));
                    break;
                case "multiplication":
                    calculator.setOperation(new Multiplication(operand1,operand2));
                    break;
                case "division":
                    if (operand2==0) {
                        System.out.println("Error division by zero !");
                        continue;
                    }
                    calculator.setOperation(new Division(operand1,operand2));
                    break;
                case "puissance":
                    calculator.setOperation(new Puissance(operand1,operand2));
                    break;
                case "square root":
                    if (operand1<0) {
                        System.out.println("Erreurr, la racine carré d'un nombre négatif est invalide ! ");
                        continue;
                    }
                    calculator.setOperation(new SquareRoot(operand1));
                    break;
                default:
                    System.out.println("Invalid operation, try again !");
                    continue;

            }

            try {
                double result= calculator.applyOperation();
                System.out.println("The result is: "+result);
            } catch (Exception e) {
                System.out.println("Error : "+e.getMessage());
            }
            scanner.nextLine();
            System.out.print("Do you want to do another operation ? (yes/no) : ");
            String response=scanner.nextLine().toLowerCase();
            on=response.equals("yes");

        }

        scanner.close();
        System.out.println("Thank you for trying the calculator !");

    }
}
