package com.example.root.sqllite;

public class Account {
    private int id;
    private String name;
    private String accNo;
    private double balance;

    public Account() {

    }

    public Account(int id, String name, String accNo, double balance) {
        this.id = id;
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
