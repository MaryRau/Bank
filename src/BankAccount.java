public class BankAccount {
    private float balance;
    private int accountNumber;

    public BankAccount(int accountNumber, float initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(float amount) {
        balance += amount;
        System.out.println("Внесено: " + amount + " рублей");
        System.out.println("Новый баланс: " + balance + " рублей");
    }

    public void withdraw(float amount) {
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

    public int getAccountNumber() {
        return accountNumber;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(12345678, 1000.0f);

        account.deposit(500.0f);
        account.withdraw(300.0f);
        account.withdraw(1500.0f);

        System.out.println("Номер счета: " + account.getAccountNumber());
        System.out.println("Баланс: " + account.getBalance() + " рублей");
    }
}