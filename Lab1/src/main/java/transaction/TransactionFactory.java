package transaction;

public class TransactionFactory {
    public static Transaction createDebit(float cash, String message) {
        return new Transaction(cash, 0f, message);
    }

    public static Transaction createCredit(float cash, String message) {
        return new Transaction(0f, cash, message);
    }

    public static Transaction createCountableDebit(float cash, int quantity, String message) {
        return new Transaction(cash, 0f, quantity, message);
    }

    public static Transaction createCountableCredit(float cash, int quantity, String message) {
        return new Transaction(0f, cash, quantity, message);
    }
}
