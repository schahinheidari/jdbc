package fr.tln.bank_management.entity;

import java.util.HashSet;
import java.util.Set;

public class Client extends User{

    private Set<Account> accounts = new HashSet<>();

}
