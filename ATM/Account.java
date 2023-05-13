import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
    private int customerNum;
    private int customerPIN;
    private double checkingsBalance = 0;
    private double savingsBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    public Account(int customerNum, int customerPIN, double checkingsBalance, double savingsBalance) {
        this.customerNum = customerNum;
        this.customerPIN = customerPIN;
        this.checkingsBalance = checkingsBalance;
        this.savingsBalance = savingsBalance;
    }
    
    public int getCustomerNumber() {
        return customerNum;
    }
    public void setCustomerNumber() {
        this.customerNum = customerNum;
    }
    public int getCustomerPIN() {
        return customerPIN;
    }
    public void setCustomerPIN() {
        this.customerPIN = customerPIN;
    }
    public double getCheckingsBalance() {
        return checkingsBalance;
    }
    public void setCheckingsBalance() {
        this.checkingsBalance = checkingsBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }
    public void setSavingsBalance() {
        this.savingsBalance = savingsBalance;
    }
    public double calcCheckingWithdraw(double amount) {
        checkingsBalance = (checkingsBalance - amount);
        return checkingsBalance;
    }
    public double calcSavingWithdraw(double amount) {
        savingsBalance = (savingsBalance - amount);
        return savingsBalance;
    }
    public double calcCheckingDeposit(double amount) {
        checkingsBalance = (checkingsBalance + amount);
        return checkingsBalance;
    }
    public double calcSavingDeposit(double amount) {
        savingsBalance = (savingsBalance + amount);
        return savingsBalance;
    }
    public void calcCheckToSaveTransfer(double amount) {
        checkingsBalance = (checkingsBalance - amount);
        savingsBalance = (savingsBalance + amount);
    }
    public void calcSaveToCheckTransfer(double amount) {
        checkingsBalance = (checkingsBalance + amount);
        savingsBalance = (savingsBalance - amount);
    }

    public void getCheckingsWithdrawInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingsBalance));
                System.out.print("\nAmount you want to withdraw from checkings account: ");
                double amount = input.nextDouble();
                if ((checkingsBalance - amount) >= 0 && amount >= 0) {
                    calcCheckingWithdraw(amount);
                    System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingsBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance cannot be negative.");
                }
            }
            catch (InputMismatchException exc) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    public void getSavingsWithdrawInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingsBalance));
                System.out.print("\nAmount you want to withdraw from savings account: ");
                double amount = input.nextDouble();
                if ((checkingsBalance - amount) >= 0 && amount >= 0) {
                    calcSavingWithdraw(amount);
                    System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingsBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance cannot be negative.");
                }
            }
            catch (InputMismatchException exc) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    public void getCheckingsDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingsBalance));
                System.out.print("\nAmount you want to withdraw from checkings account: ");
                double amount = input.nextDouble();
                if ((checkingsBalance + amount) >= 0 && amount >= 0) {
                    calcCheckingDeposit(amount);
                    System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingsBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance cannot be negative.");
                }
            }
            catch (InputMismatchException exc) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    public void getSavingsDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingsBalance));
                System.out.print("\nAmount you want to withdraw from savings account: ");
                double amount = input.nextDouble();
                if ((savingsBalance + amount) >= 0 && amount >= 0) {
                    calcSavingDeposit(amount);
                    System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingsBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance cannot be negative.");
                }
            }
            catch (InputMismatchException exc) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    public void getTransferInput(String accountType) {
        boolean end = false;
        while (!end) {
            try {
                if (accountType.equals("Checkings")) {
                    System.out.println("\nSelect an account you would like to transfer funds to: ");
                    System.out.println("1. Savings");
                    System.out.println("2. Exit");
                    System.out.println("\n Choice: ");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingsBalance));
                            System.out.print("\nAmount you want to withdraw from savings account: ");
                            double amount = input.nextDouble();
                            if ((savingsBalance + amount) >= 0 && (checkingsBalance - amount) >= 0 && amount >= 0) {
                                calcCheckToSaveTransfer(amount);
                                System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingsBalance));
                                System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingsBalance));
                                end = true;
                            } else {
                                System.out.println("\nBalance cannot be negative.");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Choice.");
                            break;
                    }
                }
                else if (accountType.equals("Savings")) {
                    System.out.println("\nSelect an account you would like to transfer funds to: ");
                    System.out.println("1. Checkings");
                    System.out.println("2. Exit");
                    System.out.println("\n Choice: ");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingsBalance));
                            System.out.print("\nAmount you want to withdraw from checkings account: ");
                            double amount = input.nextDouble();
                            if ((checkingsBalance + amount) >= 0 && (savingsBalance - amount) >= 0 && amount >= 0) {
                                calcSaveToCheckTransfer(amount);
                                System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingsBalance));
                                System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingsBalance));
                                end = true;
                            } else {
                                System.out.println("\nBalance cannot be negative.");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Choice.");
                            break;
                    }
                }
            }
            catch (InputMismatchException exc) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }
}
