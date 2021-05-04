package hu.meiit.haladojava.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    private static final DecimalFormat decimalformat = new DecimalFormat("#.0");

    public void writeMessage(String message) {
        System.out.println(message);
    }

    public String readExpression() {
        return scanner.nextLine();
    }

    public void writeResult(double result) {
        System.out.print(decimalformat.format(result));
    }

}
