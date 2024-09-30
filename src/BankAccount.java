public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Внесено: " + amount + " рублей");
        System.out.println("Новый баланс: " + balance + " рублей");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Снято: " + amount + " рублей");
            System.out.println("Новый баланс: " + balance + " рублей");
        }
        else {
            System.out.println("Недостаточно средств. Снятие не выполнено.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345678", 1000.0);

        account.deposit(500.0);
        account.withdraw(300.0);
        account.withdraw(1500.0);

        System.out.println("Номер счета: " + account.getAccountNumber());
        System.out.println("Баланс: " + account.getBalance() + " рублей");
    }
}