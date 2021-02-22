package hu.meiit.haladojava.calculator;


import java.util.Arrays;

import static hu.meiit.haladojava.calculator.Calculations.*;

public class Expression {
    private final int operand1;
    private final int operand2;
    private final char operator;

    public Expression(String expression) throws Exception{
        String[] preprocessed =preProcess(expression);
        int[] operands= numberCheck(preprocessed);
       this.operand1 = operands[0];
       this.operand2 = operands[1];
       this.operator = preprocessed[1].charAt(0);
    }

    private String[] preProcess(String expression) throws InvalidInputException {
        String[] preprocessed= new String[3];
        String[] temp=expression.replaceAll(" ","").split("(?<=(\\+|\\*|-|/))");
        if (temp.length!=2)
            throw new InvalidInputException();
        preprocessed[1]= String.valueOf(temp[0].charAt(temp[0].length()-1));
        preprocessed[0]=temp[0].substring(0,temp[0].length()-1);
        preprocessed[2]=temp[1];
        return preprocessed;
    }

    private int[] numberCheck(String[] preprocessed){
        int[] operands= new int[2];
        operands[0]=Integer.parseInt(preprocessed[0]);
        operands[1]=Integer.parseInt(preprocessed[2]);
        return operands;
    }

    public double calculate() throws InvalidInputException{
        switch(this.operator){
            case '+': return addition(this.operand1,this.operand2);
            case '-': return substraction(this.operand1,this.operand2);
            case '*': return multiplycation(this.operand1,this.operand2);
            case '/': return division(this.operand1,this.operand2);
            default: throw new InvalidInputException();
        }
    }



}
