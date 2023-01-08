package ru.yandex.praktikum.debug;

public class CatFeeder {

    private int balance;

    public CatFeeder(int balance) {
        this.balance = balance;
    }

    public void weeklyFeed(int dailyRation) {
        for (int i = 1; i < 7; i++) {
            System.out.println("День '" + i + "', остаток корма: '" + this.balance + "'");
            printDayType(i);
            this.balance -= dailyRation;
        }
    }

    private static void printDayType(int dayOfWeek) {
        if (DayOfWeek.days[dayOfWeek].equals("Суббота")) {
            System.out.println("Выходной день.");
        }
        if (DayOfWeek.days[dayOfWeek].equals("Воскресенье")) {
            System.out.println("Выходной день.");
        }
        else {
            System.out.println("Рабочий день.");
        }
    }
}
