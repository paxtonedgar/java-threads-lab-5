import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SavingsAccount bankAccount = new SavingsAccount();

        Thread t1 = new Thread(() -> {
            bankAccount.deposit(100);
            bankAccount.withdraw(75);
            bankAccount.withdraw(200);
            bankAccount.deposit(25);
            bankAccount.deposit(100);

        });
        Thread t2 = new Thread(() -> bankAccount.withdraw(50));

        Thread t3 = new Thread(() -> {
            bankAccount.withdraw(25);
            bankAccount.deposit(100);
            bankAccount.deposit(35);
            bankAccount.withdraw(25);
            bankAccount.withdraw(45);
        } );

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println(bankAccount.getTotal());
    }


}
