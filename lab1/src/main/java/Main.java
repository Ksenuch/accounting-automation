import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var bank = new Account("Банк");
        var a1 = new Account("Деньги");
        var a2 = new Account("Товары");

        // Займ 1000р
        bank.operations.add(new Operation(0, 1000, 0, "Занимаем 1000р"));
        a1.operations.add(new Operation(1000, 0, 0, "Занимаем 1000р"));
        // Закупка товарами
        a2.operations.add(new Operation(100, 0, 10, "10 Товаров по 100р"));
        a1.operations.add(new Operation(0, 100, 10, "10 Товаров по 100р"));
        // Продажа товаров
        a2.operations.add(new Operation(0, 100, 10, "10 Товаров купленных по 100р"));
        a1.operations.add(new Operation(150, 0, 10, "10 Товаров купленных по 100р, продаем по 150"));

        System.out.println("Выручка " + a1.getRemainder());
        // Отдаем банку 1000р
        a1.operations.add(new Operation(0, 1000, 0, "Отдаем банку 1000р"));
        bank.operations.add(new Operation(1000, 0, 0, "Отдаем банку 1000р"));
        System.out.println("Прибыль " + a1.getRemainder());
        System.out.println("Долг: " + bank.getRemainder());
    }
}
