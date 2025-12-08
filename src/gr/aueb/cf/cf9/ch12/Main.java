package gr.aueb.cf.cf9.ch12;

public class Main {

    public static void main(String[] args) {
        Account aliceAccount = new Account(1L, "GR12345", "Alice", "W.", "A12345", 100);

        try {
            aliceAccount.deposit(500);
            System.out.println(aliceAccount.accountToString());

            aliceAccount.withdraw(100, "A12345");
            System.out.println(aliceAccount.accountToString());

            aliceAccount.withdraw(100, "A12345675");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
