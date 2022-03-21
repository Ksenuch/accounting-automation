package transaction;

import lombok.Getter;

public class Transaction {

    Transaction(float debitCash, float creditCash, int quantity, String message) {
        this.debitCash = debitCash;
        this.creditCash = creditCash;
        this.quantity = quantity;
        this.message = message;
    }

    Transaction(float debitCash, float creditCash, String message) {
        this(debitCash, creditCash, 0, message);
    }

    protected float debitCash;
    protected float creditCash;
    @Getter
    protected String message;

    @Getter
    protected int quantity;

    public float getDebitCash() {
        if(this.quantity > 0)
            return debitCash * quantity;

        return debitCash;
    }

    public float getCreditCash() {
        if(this.quantity > 0)
            return creditCash * quantity;

        return creditCash;
    }

    @Override
    public String toString() {
        return "Transaction.Transaction{" +
                "debitCash=" + debitCash +
                ", creditCash=" + creditCash +
                ", message='" + message + '\'' +
                '}';
    }
}
