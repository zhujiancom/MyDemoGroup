package com.zj.demo.beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Creator: zhuji
 * Date: 11/4/2018
 * Time: 12:43 AM
 * Description:
 */
@SuppressWarnings("restriction")
@XmlRootElement(name = "transactionRecord")
public class Transaction {
    private String username;
    private int userId;
    private Date transactionDate;
    private double amount;

    /* getters and setters for the attributes */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction [username=" + username + ", userId=" + userId + ", transactionDate=" + transactionDate + ", amount=" + amount + "]";
    }
}
