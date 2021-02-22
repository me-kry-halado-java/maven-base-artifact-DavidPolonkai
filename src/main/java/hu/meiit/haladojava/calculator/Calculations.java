package hu.meiit.haladojava.calculator;


public class Calculations {

    private Calculations(){
        super();
    }


    public static double addition(int a, int b){
        return (double)a+b;
    }

    public static double substraction(int a, int b){
        return (double)a-b;
    }

    public static double multiplycation(int a, int b){
        return (double)a*b;
    }

    public static double division(int a, int b) throws ArithmeticException{
        if (b==0) throw new ArithmeticException();
        return (double)a/b;
    }
}
