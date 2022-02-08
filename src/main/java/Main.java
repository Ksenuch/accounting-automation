import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Account loans = new Account("Мои займы");
        Account pocket = new Account("Мои деньги");
        Account warehose = new Account("Мой склад");

        // Сумма для займа 500-5000 рублей
        int someLoanMoney = getInt(500, 5000);
        System.out.println("Я заняла: " + someLoanMoney);

        // Займ
        loans.operations.add(new Operation(TypeOfOperation.Credit, someLoanMoney, 0, "Заняла"));
        pocket.operations.add(new Operation(TypeOfOperation.Debit, someLoanMoney, 0, "Заняла"));

        // Генерирую цену
        int price = getInt(10, 100);
        int amountOfProducts = someLoanMoney / price;
        System.out.println("Куплю вот столько товаров: " + amountOfProducts);
        System.out.println("По вот такой цене: " + price);

        // Закупка товарами
        warehose.operations.add(new Operation(TypeOfOperation.Debit, price, amountOfProducts, "10 Товаров по 100р"));
        pocket.operations.add(new Operation(TypeOfOperation.Credit, price, amountOfProducts, "10 Товаров по 100р"));

        // Гененрирую наценку
        int percent = getInt(0, 100);
        System.out.println("Буду продавать с такой наценкой в %: " + percent);
        int newPrice = (int) (price + (float)price / 100 * percent);
        System.out.println("Новая цена: " + newPrice);

        // Продажа товаров
        warehose.operations.add(new Operation(TypeOfOperation.Credit, price, amountOfProducts, "10 Товаров купленных по 100р"));
        pocket.operations.add(new Operation(TypeOfOperation.Debit, newPrice, amountOfProducts, "10 Товаров купленных по 100р, продаем по 150"));

        // Отдаю долги
        pocket.operations.add(new Operation(TypeOfOperation.Credit, someLoanMoney, 0, "Отдала долг"));
        loans.operations.add(new Operation(TypeOfOperation.Debit, someLoanMoney, 0, "Ребята получили обратно деньги"));

        System.out.println("Выручка: " + newPrice * amountOfProducts);
        System.out.println("Долги: " + loans);
        System.out.println("Чистая прибыль: " + pocket.getMoney());

        System.out.println("Информация о всех счетах:");
        System.out.println("Мои деньги: " + pocket.getMoney());
        System.out.println("Мой склад: " + warehose.getMoney());
        System.out.println("Долги: " + loans.getMoney());
    }

    static int getInt(int left, int right) {
        return new Random().nextInt(right) + left;
    }
}
