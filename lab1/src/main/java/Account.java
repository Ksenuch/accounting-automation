import java.util.ArrayList;

public class Account {
    private String name;
    public ArrayList<Operation> operations = new ArrayList<>();

    public Account(String name) {
        this.name = name;
    }

    public int getRemainder() {

        int result = 0;

        for (var operation : operations) {
            result += operation.count();
        }

        return  result;
    }
}
