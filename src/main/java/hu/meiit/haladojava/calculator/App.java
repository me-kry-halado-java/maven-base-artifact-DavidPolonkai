package hu.meiit.haladojava.calculator;

public class App {
    private static final String ERROR_MESSAGE = "-";

    public static void main(String[] args) {

        View view = new View();
        try {
            Expression expression = new Expression(view.readExpression());
            double result = expression.calculate();
            view.writeResult(result);

        } catch (Exception e) {
            view.writeMessage(ERROR_MESSAGE);
        }

    }
}
