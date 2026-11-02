
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AtmSimulationQueue {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int balance = 1000000;
        Queue<Integer> transactions = new LinkedList<>();

        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1) Deposit");
            System.out.println("2) Withdrawal");
            System.out.println("3) Check Balance");
            System.out.println("4) Amount Deposited");
            System.out.println("5) Amount Withdrawn");
            System.out.println("6) Transactions");
            System.out.println("0) Exit");

            System.out.print("\nSelect Menu: ");
            int menu = input.nextInt();

            if (menu == 0) {
                System.out.println("Thank you for using ATM!");
                break;
            }

            switch (menu) {

                case 1:
                    System.out.print("Input amount: ");
                    int deposit = input.nextInt();

                    if (deposit <= 0) {
                        System.out.println("Invalid amount!");
                        break;
                    }

                    balance += deposit;
                    transactions.offer(deposit);

                    System.out.println("Deposit successful!");
                    break;

                case 2:
                    System.out.print("Input amount: ");
                    int withdrawal = input.nextInt();

                    if (withdrawal <= 0) {
                        System.out.println("Invalid amount!");
                        break;
                    }

                    if (balance < withdrawal) {
                        System.out.println("Insufficient balance!");
                        break;
                    }

                    balance -= withdrawal;
                    transactions.offer(-withdrawal);

                    System.out.println("Withdrawal successful!");
                    break;

                case 3:
                    System.out.println("Balance: " + balance);
                    break;

                case 4:
                    int totalDeposit = 0;

                    for (int transaction : transactions) {
                        if (transaction > 0) {
                            totalDeposit += transaction;
                        }
                    }

                    System.out.println("Total Deposit: " + totalDeposit);
                    break;

                case 5:
                    int totalWithdrawn = 0;

                    for (int transaction : transactions) {
                        if (transaction < 0) {
                            totalWithdrawn += Math.abs(transaction);
                        }
                    }

                    System.out.println("Total Withdrawn: " + totalWithdrawn);
                    break;

                case 6:
                    System.out.println("Transaction History:");

                    if (transactions.isEmpty()) {
                        System.out.println("No transactions yet.");
                    }

                    int count = 1;

                    for (int transaction : transactions) {

                        if (transaction > 0) {
                            System.out.println(
                                count + ". Deposit: " + transaction
                            );
                        } else {
                            System.out.println(
                                count + ". Withdrawal: "
                                + Math.abs(transaction)
                            );
                        }

                        count++;
                    }
                    break;

                default:
                    System.out.println("Invalid menu!");
            }
        }

        input.close();
    }
}
