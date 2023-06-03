package ucr.ac.cr.userservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Bank_Account")
public class BankAccount {
    @Id
    @Column(name = "Account_number", unique = true, nullable = false)
    private int accountNumber;

    @Column(name = "Account_Name", unique = false, length = 100, nullable = false)
    private String accountName;

    @Column(name = "Bank_name", unique = false, length = 100, nullable = false)
    private String bankName;

    @Column(name = "Account_type", unique = false, length = 1, nullable = false)
    private char accountType;

    @Column(name = "Current_balance", unique = false, nullable = false)
    private Float currentBalance;

    @Column(name = "Card", unique = false, length = 4, nullable = false)
    private String card;

    @Column(name = "IBAN", unique = false, length = 100, nullable = false)
    private String iban;

    @Column(name = "Phone_number", unique = false, length = 8, nullable = false)
    private String phoneNumber;

    @ManyToOne()
    @JoinColumn(name = "Account_Id")
    private AppAccount appAccount;

    public BankAccount() {
    }

    public BankAccount(int accountNumber, String accountName, String bankName, char accountType, Float currentBalance, String card, String iban, String phoneNumber, AppAccount appAccount) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.bankName = bankName;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
        this.card = card;
        this.iban = iban;
        this.phoneNumber = phoneNumber;
        this.appAccount = appAccount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public char getAccountType() {
        return accountType;
    }

    public void setAccountType(char accountType) {
        this.accountType = accountType;
    }

    public Float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AppAccount getAppAccount() {
        return appAccount;
    }

    public void setAppAccount(AppAccount appAccount) {
        this.appAccount = appAccount;
    }
}
