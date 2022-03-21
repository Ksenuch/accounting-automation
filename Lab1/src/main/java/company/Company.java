package company;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

public class Company {
    @Getter
    String name;
    private List<Account> accounts;

    public Company(String name, Account... accounts) {
        this.name = name;
        this.accounts = new ArrayList<Account>();

        for (var account : accounts)
            this.accounts.add(account);
    }

    public Account getAccountByName(String acccontName) {
        for (var account : accounts)
            if(account.getName() == acccontName)
                return account;

        return null;
    }

    public Account getAccountById(int id) {
        for (var account : accounts)
            if(account.getId() == id)
                return account;

        return null;
    }

    public Company(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public float getIncome() {
        float income = 0;

        for(var account : accounts)
            income += account.count();

        return income;
    }

    public void moveMoney(int idFrom, int idTo, float cash, String message) {
        try {
            var accFrom = this.getAccountById(idFrom);
            var accTo = this.getAccountById(idTo);

            accFrom.transferTo(cash, message, accTo);

            System.out.println("Переведено со счёта " + accFrom.getName() + " на счёт " + accTo.getName() + " сумма - " + cash);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buyToAccount(int expendId, float cash, int quantity, String message, int incomeId) {
        var accFrom = this.getAccountById(expendId);
        var accTo = this.getAccountById(incomeId);

        this.getAccountById(expendId).buy(cash, quantity, message, this.getAccountById(incomeId));

        System.out.println("Куплено " + quantity + " товаров за " + cash + "  на " + accFrom.getName() + " со счёта " + accTo.getName());
    }

    public void sellFromAccont(int expendId, float oldPrice, int marginPercent, int quantity, String message, int incomeId) {
        var accFrom = this.getAccountById(expendId);
        var accTo = this.getAccountById(incomeId);

        this.getAccountById(expendId).sell(oldPrice, marginPercent, quantity, message, this.getAccountById(incomeId));

        System.out.println("Продано с " + accFrom.getName() + " на счёт " + accTo.getName() + " " + quantity + " товаров " + "за " + (oldPrice + oldPrice / 100 * marginPercent));
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", income=" + getIncome() +
                '}';
    }
}
