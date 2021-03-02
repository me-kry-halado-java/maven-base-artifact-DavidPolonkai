package hu.meiit.haladojava.calculator;

public class Calculations {

    public Calculations() {
        super();
    }

    public double addition(int a, int b) {
        return (double) a + b;
    }

    public double substraction(int a, int b) {
        return (double) a - b;
    }

    public double multiplication(int a, int b) {
        return (double) a * b;
    }

    public double division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return (double) a / b;
    }

}
