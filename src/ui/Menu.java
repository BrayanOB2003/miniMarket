package ui;

import java.time.LocalDate;
import java.util.Scanner;

import exception.ExceptionDate;
import exception.ExceptionTypeID;
import model.Store;


public class Menu {

    private static Scanner sc = new Scanner(System.in);
    private Store store;

    public Menu() {
        store = new Store();
    }

    private void optionMenu() {
        System.out.println ("Options menu");
        System.out.println ("1. Add a record");
        System.out.println ("2. Check the number of people who have tried to enter the minimarket");
        System.out.println ("3. Check number of records");
        System.out.println ("4. Exit\n");
    }

    public String addRecord() {
	
	    boolean validType = false;
	    int select = 0;
	
	    while (!validType) {
	    	System.out.println ("Enter the identification type");
	    	System.out.println ("1- IT, Identity Card");
	    	System.out.println ("2- CC, Citizenship Certificate");
	    	System.out.println ("3- PP, Passport");
	    	System.out.println ("4- CE, Immigration Certificate\n");
	
	        select = Integer.parseInt(sc.nextLine());
	
	        if (select == 1 || select == 2 || select == 3 || select == 4) {
	            validType = true;
	        }
	    };
	
	    System.out.println("\nEnter the identification number\n\n");

	    int idNumber = -1;
	    do {
	        try {
	            idNumber = Integer.parseInt(sc.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("The record could not be added, only numeric characters are accepted\n");
	        }
	    } while (idNumber == -1);
	    
	    try {
	        store.addRecord(LocalDate.now(), select - 1, idNumber);
	        
	        System.out.println("Added record\n");
	    } catch (ExceptionTypeID e) {
	    	
	    	System.out.println ("Could not add record, document type is invalid\n");

	    } catch (ExceptionDate e) {
	    	System.out.println ("The record could not be added, you cannot enter the mini-store this day\n");

	    }
	
	    store.addCount();
	
	    return "Attempt added";
	}

	public void doOperation(int choice) {
        switch (choice) {
        case 1:
            System.out.println("\n"+addRecord()+"\n");
            break;

        case 2:
            System.out.println("\n"+attendsCount()+"\n");
            break;

        case 3:
            System.out.println("\n"+recordsCount()+"\n");
            break;

        case 4:
        	System.out.println ("THANK YOU");
            break;

        default:
        	System.out.println ("Please enter a valid option\n");
            break;
        }
    }

    public int option() {

        int select = Integer.parseInt(sc.nextLine());
        return select;
    }

    public String attendsCount() {
	    return store.getCount() + "Registration attempts";
	}

	public void startProgram() {
        int option;
        do {
            optionMenu();
            option = option();
            doOperation(option);
        } while (option != 4);
    }


    public String recordsCount() {
        return store.getRecords().size() + "records currently";
    }
}