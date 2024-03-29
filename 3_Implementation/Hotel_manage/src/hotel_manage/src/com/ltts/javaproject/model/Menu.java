package com.ltts.javaproject.model;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu  {

    Scanner input = new Scanner(System.in);

    Room[] myHotel = new Room[11];
    booking bk=new booking();

    static String choice;
    static String roomName;
    static int roomNum = 1;
    static String answer;
    class  Product  extends Room{
  	  // properties
  	  private String pname;
  	  private int qty;
  	  private double price;
  	  private double totalPrice;

  	  // constructor
  	  Product(String pname, int qty, 
  	              double price, double totalPrice) {
  	    this.pname = pname;
  	    this.qty = qty;
  	    this.price = price;
  	    this.totalPrice = totalPrice;
  	  }

  	  // getter methods
  	  public String getPname() {
  	    return pname;
  	  }
  	  public int getQty() {
  	    return qty;
  	  }
  	  public double getPrice() {
  	    return price;
  	  }
  	  public double getTotalPrice() {
  	    return totalPrice;
  	  }


  	  // display
  	  public void display() {
  	    System.out.format("%-9s %8d %10.2f %10.2f\n", 
  	         pname, qty, price, totalPrice);
  	  }
  	}

    Queue queueObj = new Queue(); 

    public void menu() {
        System.out.println("======================================================");
        System.out.println("*            Hotel Management System                 *");
        System.out.println("======================================================");
        System.out.println("* A. View all the rooms                              *");
        System.out.println("* B. Add customer to room                            *");
        System.out.println("* C. Display avilable  rooms                         *");
        System.out.println("* D. Delete customer from room                       *");
        System.out.println("* E. Find room by customer name                      *");
        System.out.println("* F. Booking of room                                 *");
        System.out.println("* G. Display data                                    *");
        System.out.println("* H. View rooms Ordered alphabetically by name       *");
        System.out.println("* I. Display the names of the first 3 customers      *");
        System.out.println("* J. Shopping                                        *");
        System.out.println("* Q. Quit Program                                    *");
        System.out.println("======================================================");
        System.out.println("");

        System.out.println("Choose one of the options from above. (E.g: Type 'A' to view all the rooms)");

        do {
            System.out.println();
            System.out.print("Choice : ");
            choice = input.next();
            String selection = choice.toLowerCase();
            switch (selection) {

                case "a":
                    viewRooms();
                    break;
                case "b":

                    addCustomer();
                    break;

                case "c":
                    displayEmptyRooms();
                    break;

                case "d":
                    deleteCustomer();
                    break;

                case "e":
                    findRoom();
                    break;

                case "f":
                	bk.getdata();
                	bk.show();
                    break;

                case "g":
                    bk.show();
                    menu();
                    break;

                case "h":
                    alphabeticalOrder();
                    break;

                case "i":
                    queueObj.displayQueue();
                    menu();
                    break;
                    
                case "j":
                    Shopping();
                    break;


                case "q":
                	 new Room().run(); 
                    System.out.println("Thanks");
                    break;

                default:
                    System.out.println("Invalid input! Please Enter one of these letters: A,B,C,D,E,F,G,H,Q");
            }
        }
        while (!(choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("b") || choice.equalsIgnoreCase("c") || choice.equalsIgnoreCase("d") ||
                choice.equalsIgnoreCase("f") || choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("g") || choice.equalsIgnoreCase("h") ||
                choice.equalsIgnoreCase("i") || choice.equalsIgnoreCase("q") || choice.equalsIgnoreCase("j"))); 
    }

    public void Shopping() {
    	 // variables
	    String productName = null;
	    int quantity = 0;
	    double price = 0.0;
	    double totalPrice = 0.0;
	    double overAllPrice = 0.0;
	    char choice = '\0';

	    Scanner scan = new Scanner(System.in);

	    List<Product> product = new ArrayList<Product>();

	    do {
	      System.out.println("Enter product details,");
	      System.out.print("Name: ");
	      productName = scan.nextLine();
	      System.out.print("Quantity: ");
	      quantity = scan.nextInt();
	      System.out.print("Price (per item): ");
	      price = scan.nextDouble();

	      totalPrice = price * quantity;

	   
	      overAllPrice += totalPrice;

	      
	      product.add( new Product(
	          productName, quantity, price, totalPrice) );

	     
	      System.out.print("Want to add more item? (y or n): ");
	      choice = scan.next().charAt(0);

	      scan.nextLine();
	    } while (choice == 'y' || choice == 'Y');

	     displayFormat();
	    for (Product p : product) {
	      p.display();
	    }

	    System.out.println("\nTotal Price = " + overAllPrice);
	    System.out.println("\n ----Thanks for comming --- visit again----");
	    scan.nextLine();

	    menu();
	  }

	private void displayFormat() {
		System.out.print(
    	        "\nName      Quantity    Price   Total Price\n");
		
		
	}

	public void initialize() {
        for (int x = 1; x < 11; x++) {
            myHotel[x] = new Room(); 
        }
    }

    public void viewRooms() {
        for (int x = 1; x < 11; x++) 
       {
          
            if (!myHotel[x].getName().equals("e")) {
                System.out.println("Room No. " + x + " occupied by " + myHotel[x].getName());
             
            } else {
                System.out.println("Room No. " + x + " is empty");
            }

        }
        input.nextLine();
        menu();
    }

    public void addCustomer() {

        boolean invalidRoomNumber; 

        do {
            try {
                System.out.println("Enter room number (1-10)");
                roomNum = input.nextInt();
             
                if (!myHotel[roomNum].getName().equals("e")) {
                    invalidRoomNumber = true;
                    System.out.println("This room is occupied by: Mr. " + myHotel[roomNum].getName());
                    System.out.println("");
                    
                } else if (roomNum >= 1 && roomNum < 11) {
                    invalidRoomNumber = false;
                    //Error message to be displayed
                } else {
                    invalidRoomNumber = true;
                    System.out.println("Invalid input! Please Enter a value between 1-10");
                    System.out.println("");
                }
                //if the input is out of the range of the hotel array this will catch it
            } catch (IndexOutOfBoundsException e) {
                invalidRoomNumber = true;
                System.out.println("Invalid input! Please Enter a value between 1-10");
                System.out.println("");
                //to deal with exceptions regarding null values
            } catch (NullPointerException e) {
                invalidRoomNumber = true;
                System.out.println("Invalid input! Please Enter a value between 1-10");
                System.out.println("");
                //to deal with inputs other than integers
            } catch (InputMismatchException e) {
                invalidRoomNumber = true;
                System.out.println("Invalid input! Please Enter a value between 1-10");
                System.out.println("");
                input.next();
            }
        } while (invalidRoomNumber);
        System.out.println("Enter the name of the customer :");
        //Getting the customer's name
        roomName = input.next();
        //Setting the customer name
        myHotel[roomNum].setName(roomName);
        queueObj.addToQueue(roomName);

        //this will let you choose whether to add more data or not
        try {
            do {
                System.out.println("Do you want to continue adding records?(Y/N)");
                answer = input.next();
                String selection = answer.toLowerCase();

                switch (selection) {
                    case "y":
                        addCustomer();

                    case "n":
                        System.out.println("");
                        menu();
                }

            } while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")));

        } catch (InputMismatchException e) {
            System.out.println("");
        }
    }

    public void displayEmptyRooms() {
        //this method will display all the empty rooms
        for (int x = 1; x < 11; x++) {
            if (myHotel[x].getName().equals("e")) {
                System.out.println("room " + x + " is empty");
            }
        }
        System.out.println("");
        input.nextLine();
        menu();
    }

    private void deleteCustomer() {

        boolean invalidInput;

        do {
            invalidInput = false;
            try {
                System.out.println("please enter the Room's number which you want to vacate");
                roomNum = input.nextInt();

                //if the hotel room is not empty then this will delete the customer from that room
                if (!(myHotel[roomNum].getName().equals("e"))) {
                    invalidInput = false;
                    myHotel[roomNum].setName("e");

                    //if the room is already empty then this message will be displayed
                } else {
                    invalidInput = true;
                    System.out.println("Room " + roomNum + " is already Empty");
                    System.out.println("");
                }

                //if the input is not an integer value then this will catch it
            } catch (InputMismatchException e) {
                invalidInput = true;
                System.out.println("Invalid input! Please Enter a value between 1-10");
                System.out.println("");
                input.next();

                //if the input is out of the range of the hotel array this will catch it
            } catch (IndexOutOfBoundsException e) {
                invalidInput = true;
                System.out.println("Invalid room number. Please enter a value between 1-10");
                input.next();
            }

        } while (invalidInput);//This will print the room's number which has been successfully vacated
        System.out.println("Room " + roomNum + " has successfully been vacated");

        System.out.println("");
        input.nextLine();
        menu();
    }

    public void findRoom() {
        System.out.println("Please enter the name of the customer");
        boolean found = false;
        String find = input.next();


        for (int n = 1; n < 11; n++) {
            //used equalsIgnoreCase to avoid case sensitive issues while searching for a customer
            //this method will find the room's number which is currently being occupied by the mentioned customer
            if (myHotel[n].getName().equalsIgnoreCase(find)) {
                found = true;
                System.out.println("Mr. " + find + " is staying in room No. " + n);
                System.out.println("");
                menu();
            }
        }
        //this will let ou know if the customer is not there in the database
        if (found == false) {
            System.out.println(find + " doesn't exist on our database");
            System.out.println("");
            input.nextLine();
            menu();
        }
    }

    public void storeData() {
        try {
            //saving Data and overwriting

            String[] storage = new String[11];

            for (int y = 1; y < 11; y++) {
                storage[y] = myHotel[y].getName();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt", false)); 
            for (int x = 1; x < storage.length; x++) {
                String file;
                file = storage[x];
                // writes Empty room if it find "e" on the array
                if (file.equals("e")) {
                    bw.write("Empty Room " + x);

                    // writes the name of the customer from the array
                } else {
                    bw.write(file);
                }
                bw.newLine(); //Line Seperator
                bw.flush(); //Flushes the stream.

            }

            //will catch this exception if the Text file is not found
        } catch (IOException e) {
            System.err.println("File not found!");
        }

        //message to show the user that the array data has been saved to a Text file successfully
        System.out.println("Data successfully saved!");
        System.out.println("");
        input.nextLine();
        menu();
    }


    public void alphabeticalOrder() {

        int index = 0;

        String[] copy = new String[11];
        String[] names = new String[11];

        for (int y = 1; y < 11; y++) {
            copy[y] = myHotel[y].getName();
        }

        //copy hotel array data to names array
        for (int x = 1; x < 11; x++) {
            names[x] = myHotel[x].getName().toLowerCase();//used this to avoid case sensitive issues.
        }

        //Flag Bubble Sort
        boolean flag = true;
        for (int i = 1; i < names.length - 1; i++) {
            flag = false;
            for (int j = i + 1; j < names.length; j++) {
                if (names[j].compareTo(names[i]) < 0) {
                    String temp = names[j];
                    names[j] = names[i];
                    names[i] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }


        //This will add the list of names in ascending order in our new array
        for (int x = 1; x < names.length; x++) {
            if (!(names[x].equals("e"))) {

                for (int i = 1; i < copy.length; i++) {
                    if (copy[i].toLowerCase().equals(names[x])) {
                        index = i;
                    }
                }
                System.out.println("Mr. " + names[x] + " is staying in room No. " + index);
            }
        }
        System.out.println("");
        input.nextLine();
        menu();

    }
}

	    
	  



