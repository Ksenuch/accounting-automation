package company;

import transaction.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Account {
    // Обязательные идентифицирующие поля
    @Getter
    private int id;
    @Getter
    private String name;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    // Конструктор
    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Записать дебит
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Перевести на счёт
    public void transferTo(float cash, String message, Account account) {
        try {
            this.addTransaction(TransactionFactory.createCountableCredit(cash, 0, message));
            account.addTransaction(TransactionFactory.createCountableDebit(cash, 0, message));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Купить
    public void buy(float cash, int quantity, String message, Account activeAccount) {
        try {
            this.addTransaction(TransactionFactory.createCountableCredit(cash, quantity, message));
            activeAccount.addTransaction(TransactionFactory.createCountableDebit(cash, quantity, message));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Продать
    public void sell(float oldPrice, int marginPercent, int quantity, String message, Account passiveAccount) {
        float newPrice = oldPrice + oldPrice / 100 * marginPercent;
        try {
            this.addTransaction(TransactionFactory.createCountableCredit(oldPrice, quantity, message));
            passiveAccount.addTransaction(TransactionFactory.createCountableDebit(newPrice, quantity, message));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public float getCurrentDebit() {
        float result = 0;
        for(Transaction transaction : transactions) {
            result += transaction.getDebitCash();
        }
        return result;
    }

    public float getCurrentCredit() {
        float result = 0;
        for(Transaction transaction : transactions) {
            result += transaction.getCreditCash();
        }
        return result;
    }

    public float count() {
        return this.getCurrentDebit() - this.getCurrentCredit();
    }

    public Transaction getLastTransaction() {
        return this.transactions.get(transactions.size() - 1);
    }

    @Override
    public String toString() {
        return "Company.Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
