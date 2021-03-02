package hu.meiit.haladojava.calculator;

public enum Operators {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char sign;

    Operators(char sign) {
        this.sign = sign;
    }

    public Operators getName(char sign) throws InvalidInputException {
        for (Operators operator : Operators.values()) {
            if (operator.sign == sign) {
                return operator;
            }
        }
        throw new InvalidInputException();
    }
}
