public class Operation {
    TypeOfOperation type;
    int money;
    int amount;
    String comment;

    public Operation(TypeOfOperation type, int money, int amount, String comment) {
        this.type = type;
        this.money = money;
        this.amount = amount;
        this.comment = comment;
    }

    public int count() {
        if(this.amount == 0) {
            return money;
        }
        else return this.money * this.amount;
    }
}
