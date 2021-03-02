package hu.meiit.haladojava.calculator;

public class Expression {
    private final int operand1;

    private final int operand2;

    private final char operator;

    private static final int NUMBER_OF_PREPROCESSED_SEQUENCES = 2;

    private static final String REGEX_OR = "|";

    private static final String REGEX_BEFORE_OPERATOR = "\\";

    private static final String REGEX_PREFIX = "(?<=(";

    private static final String REGEX_POSTFIX = "))";

    public Expression(String expression) throws InvalidInputException {
        String[] preprocessed = preProcess(expression);
        int[] operands = numberCheck(preprocessed);
        this.operand1 = operands[0];
        this.operand2 = operands[1];
        this.operator = preprocessed[1].charAt(0);
    }

    private String[] preProcess(String expression) throws InvalidInputException {
        String[] preprocessed = new String[3];
        String[] temp = expression.replace(" ", "").split(regexBuilder());
        if (temp.length != NUMBER_OF_PREPROCESSED_SEQUENCES) {
            throw new InvalidInputException();
        }
        String[] operand1AndOperator = separateOperand1AndOperator(temp[0]);
        preprocessed[1] = operand1AndOperator[0];
        preprocessed[0] = operand1AndOperator[1];
        preprocessed[2] = temp[1];
        return preprocessed;
    }

    private String[] separateOperand1AndOperator(String operand1AndOperator) {
        String[] result = new String[2];
        result[0] = operand1AndOperator.substring(0, operand1AndOperator.length() - 1);
        result[1] = String.valueOf(operand1AndOperator.charAt(operand1AndOperator.length() - 1));
        return result;
    }

    private int[] numberCheck(String[] preprocessed) {
        int[] operands = new int[2];
        operands[0] = Integer.parseInt(preprocessed[0]);
        operands[1] = Integer.parseInt(preprocessed[2]);
        return operands;
    }

    public double calculate() throws InvalidInputException {
        Calculations calculations = new Calculations();
        final Operators operators = Operators.ADDITION;
        switch (operators.getName(this.operator)) {
            case ADDITION:
                return calculations.addition(this.operand1, this.operand2);
            case SUBTRACTION:
                return calculations.substraction(this.operand1, this.operand2);
            case MULTIPLICATION:
                return calculations.multiplication(this.operand1, this.operand2);
            case DIVISION:
                return calculations.division(this.operand1, this.operand2);
            default:
                throw new InvalidInputException();
        }
    }

    private String regexBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        Operators[] operators = Operators.values();
        stringBuilder.append(REGEX_PREFIX);
        for (int i = 0; i < operators.length; i++) {
            stringBuilder.append(REGEX_BEFORE_OPERATOR);
            stringBuilder.append(operators[i]);
            if (i < operators.length - 1) {
                stringBuilder.append(REGEX_OR);
            }
        }
        stringBuilder.append(REGEX_POSTFIX);
        return stringBuilder.toString();
    }
}
