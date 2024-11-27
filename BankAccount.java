package model;

public class BankAccount {

    private String accountNumber = "";
    private double accountBalance = 0.0;
    private String customerName = "";
    private String customerEmail = "";
    private String accountPhone = "";

    public BankAccount(String accountNumber, double accountBalance, String customerName, String customerEmail, String accountPhone) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.accountPhone = accountPhone;
    }

    // Getters and Setters

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    // Method to Deposit Funds

    public void depositFunds(Double depositAmount) {

        if (depositAmount == null || depositAmount < 0) {
            System.out.println("Incorrect Value");
        } else {

            double currentAccount = getAccountBalance();
            double newAccountBalance = currentAccount + depositAmount;

            setAccountBalance(newAccountBalance);
            System.out.println("Deposit of $" + depositAmount + " made. New Balance is $" + newAccountBalance);
        }
    }

    // Method to Withdraw Funds

    public void withdrawFunds(Double withdrawalAmount) {

        if (withdrawalAmount == null || withdrawalAmount < 0) {
            System.out.println("Incorrect Value");
        } else {

            double currentAccount = getAccountBalance();

            if (currentAccount - withdrawalAmount < 0) {
                System.out.println("Insufficient funds. You only have $" + currentAccount + " in your account.");
            } else {
                currentAccount -= withdrawalAmount;
                System.out.println("Withdrawal of $" + withdrawalAmount + " processed, Remaining Balance = $" + currentAccount);
                setAccountBalance(currentAccount);
            }
        }
    }
}




