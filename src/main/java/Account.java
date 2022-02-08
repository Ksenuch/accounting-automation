import java.util.ArrayList;

public class Account {
    String name;
    public ArrayList<Operation> operations = new ArrayList<>();

    public Account(String name) {
        this.name = name;
    }

    public int getMoney() {
        var debit = 0;
        var credit = 0;

        for (var op : operations) {
            if(op.type == TypeOfOperation.Credit)
                credit += op.money;
            else
                debit += op.money;
        }

        return  debit - credit;
    }
}
