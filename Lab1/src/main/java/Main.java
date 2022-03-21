import company.*;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Company myCompany = new Company(
                "Производство товаров",
                new Account(1, "Мой краман"),
                new Account(2, "Мой склад"),
                new Account(3, "Банк")
        );

        myCompany.moveMoney(3, 1, 100, "Занял 100 у банка");
        myCompany.buyToAccount(1, 25, 4, "Купила 4 ресурсов по 25 рублей, положила на склад", 2);

        myCompany.sellFromAccont(2, 25, 50, 4, "Сделала из 4 ресурсов, 4 товара, и продаю с наценкой 50%", 1);
        myCompany.moveMoney(1, 3, 100, "Отдала 100 банку");
        System.out.println("Моя компания: " + myCompany.toString());
    }
}
