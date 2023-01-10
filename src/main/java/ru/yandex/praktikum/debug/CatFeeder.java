package ru.yandex.praktikum.debug;

public class CatFeeder {

    private int balance;

    public CatFeeder(int balance) {
        this.balance = balance;
    }

    public void weeklyFeed(int dailyRation) {
        for (int i = 1; i <= 7; i++) {
            if (balance < dailyRation) {
                System.out.println("Недостаточно корма '" + this.balance + "', а нужно '" + dailyRation + "'!");
                return;
            }
            System.out.println("День '" + i + "', остаток корма: '" + this.balance + "'");
            printDayType(i);
            this.balance -= dailyRation;
        }
    }

    private static void printDayType(int dayOfWeek) {
        if (DayOfWeek.days[dayOfWeek-1].equals("Суббота")) {
            System.out.println("Выходной день.");
        }
        else if (DayOfWeek.days[dayOfWeek-1].equals("Воскресенье")) {
            System.out.println("Выходной день.");
        }
        else {
            System.out.println("Рабочий день.");
        }
    }
}
