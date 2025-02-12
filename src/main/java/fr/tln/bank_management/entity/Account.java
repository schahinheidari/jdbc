package fr.tln.bank_management.entity;

import fr.tln.bank_management.enums.AccountType;

public class Account  {
    private int id;

    private String accountNumber;

    private AccountType accountType;

    private Client client;

    private double balance;

}
