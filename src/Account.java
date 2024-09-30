import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Account {
    private int id;
    private double balance;
    private double annualRate;
    private Date dateCreated;

    // Конструктор с id, balance и annualInterestRate
    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualRate = annualInterestRate;
        dateCreated = new Date();
    }

    public Account()
    {
        id = 0;
        balance = 0;
        annualRate = 6.5;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2001, 01, 01);
        calendar.set(Calendar.MILLISECOND, 0);
        dateCreated = calendar.getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(double annualInterestRate) {
        this.annualRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // Метод для получения ежемесячного процента
    public double getMonthlyInterest() {
        return balance * (annualRate / 100) / 12;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств на счете.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

class BankingApp {
    public static void main(String[] args) {
        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 10000.0, 4.5);
        }

        while (!isExit) {
            System.out.print("Введите ID: ");
            int id = scanner.nextInt();

            Account account = null;
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i].getId() == id) {
                    account = accounts[i];
                    break;
                }
            }

            if (account == null) {
                System.out.println("Некорректный ID счета. Попробуйте еще раз.");
                continue;
            }

            int choice;
            do {
                System.out.println("\nОсновное меню:");
                System.out.println("1: проверить баланс счета");
                System.out.println("2: снять со счета");
                System.out.println("3: положить на счет");
                System.out.println("4: выйти");
                System.out.print("Введите пункт меню: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Баланс равен " + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Введите сумму для снятия со счета: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        System.out.println("Снято: " + withdrawAmount + " руб.");
                        break;
                    case 3:
                        System.out.print("Введите сумму для пополнения: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Внесено: " + depositAmount + " руб.");
                        break;
                    case 4:
                        isExit = true;
                        break;
                    default:
                        System.out.println("Некорректный выбор. Попробуйте еще раз.");
                }
            } while (choice != 4);
        }
    }
}
