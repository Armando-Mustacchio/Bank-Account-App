package bankaccountapp;


import utitities.CSV;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) throws FileNotFoundException {
        List<Account> accounts = new LinkedList<Account>();


        //Read a CSV File then create new accounts based on that data
        String file = "C:\\Users\\amustacchio\\Desktop\\Java Scripts\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double intiDeposit = Double.parseDouble(accountHolder[3]);
            //System.out.println(name + " " + sSN + " " + " $" + intiDeposit);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, intiDeposit));
            }
            else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, intiDeposit));

            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for(Account acc: accounts) {
            System.out.println("\n****************");
            acc.showInfo();
        }

        }
    }

