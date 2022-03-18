public class Operation {
    int debit, credit;
    int amount;
    String comment;

    public Operation(int debit, int credit, int amount, String comment) {
        this.debit = debit;
        this.credit = credit;
        this.amount = amount;
        this.comment = comment;
    }

    public int count() {
        if(this.amount == 0) {
            return debit - credit;
        }
        else return (debit - credit) * this.amount;
    }
}
