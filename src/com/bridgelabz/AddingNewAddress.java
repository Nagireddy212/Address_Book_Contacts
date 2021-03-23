package com.bridgelabz;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
public class AddingNewAddress {
    public ArrayList<AddressBook> ContactsBook = new ArrayList<>();
    ArrayList<MultipleAddressBook> addressBookList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public void AddContacts()
    {
        System.out.println("Enter First Name");
        String first = scan.next();

        checkDuplicateName(first);

        System.out.println("Enter Last Name");
        String last = scan.next();

        System.out.println("Enter Address");
        String address = scan.next();

        System.out.println("Enter City");
        String city = scan.next();

        System.out.println("Enter State");
        String state = scan.next();

        System.out.println("Enter Zip Code");
        int zip = Integer.parseInt(scan.next());

        System.out.println("Enter Phone Number");
        long mobileNo = Long.parseLong(scan.next());

        System.out.println("Enter E-mail");
        String email = scan.next();

        AddressBook AddressBook = new AddressBook(first, last, address, city, state,  email,mobileNo, zip);
        ContactsBook.add(AddressBook);
        System.out.println("Contact Details added Successfully");
    }
    public void PersonDetails()
    {
        System.out.println("\n Address Book details of Person: ");
        for (AddressBook person : ContactsBook)
        {
            System.out.println(person.toString());
        }
    }
    public void EditPersonData() {
        System.out.println("\n Enter First name to edit details:");

        String name = scan.next();

        for (AddressBook person : ContactsBook) {
            System.out.println(person.toString());

            if (name.equals(person.FirstName)) {

                System.out.println("\"Select the option to edit: \n"
                        + "1) Mobile no\n"
                        + "2) Email\n"
                        + "3) Address\n"
                        + "4) Exit");
                int numbers = Integer.parseInt(scan.next());

                switch (numbers) {
                    case 1: {
                        System.out.println("Enter new Mobile number:");
                        long mobileNo = Long.parseLong(scan.next());

                        person.setMobileNo(mobileNo);
                        System.out.println("Updated Mobile number: \n");
                        break;
                    }
                    case 2: {
                        System.out.println("Enter new Email:");
                        String Email = scan.next();

                        person.setEmail(Email);
                        System.out.println("Updated Email is: \n");
                        break;
                    }
                    case 3: {
                        System.out.println("Enter your city");
                        String City = scan.next();
                        person.setCity(City);

                        System.out.println("Enter your state");
                        String State = scan.next();
                        person.setState(State);

                        System.out.println("Enter your zip code");
                        int Zip = Integer.parseInt(scan.next());
                        person.setZip(Zip);
                        System.out.println("Updated Address is: \n");
                        break;
                    }
                    default:
                        System.out.println("Please Select correct option");
                }
            } else
                System.out.println("Person do not have details Registered");
        }
    }

    public static void main(String[] args)
    {
        AddingNewAddress address = new AddingNewAddress();
        int N=0;
        while(N==0) {
            System.out.println("1.Add Contact Details");
            System.out.println("2.Display Contact Details");
            System.out.println("3.Edit Contact Details");
            System.out.println("4.Delete Contact");
            System.out.println("5.Add New Address Book Details");
            System.out.println("6.Display New Address Book Details");
            System.out.println("7.Search by Existing City");
            System.out.println("8.Search by Existing State");
            System.out.println("9.Exit");
            System.out.println("Select any one option:");
            Scanner scan = new Scanner(System.in);
            int choice = Integer.parseInt(scan.next());
            switch (choice) {
                case 1:
                    address.AddContacts();
                    break;
                case 2:
                    address.PersonDetails();
                    break;
                case 3:
                    address.EditPersonData();
                    break;
                case 4:
                    address.DeletePersonFirstname();
                    break;
                case 5:
                    address.NewAddressBook();
                    break;
                case 6:
                    address.displayAddressBook();
                    break;
                case 7:
                    address.SearchCity();
                    break;
                case 8:
                    address.SearchState();
                    break;
                case 9:
                    System.out.println("Exit");
                    N = 1;
                    break;
            }
        }
    }
    public void NewAddressBook()
    {
        System.out.println("Enter AddressBook Name");
        String userInputBookName = scan.next();
        MultipleAddressBook Addressbook = new MultipleAddressBook(userInputBookName);
        addressBookList.add(Addressbook);
        System.out.println("New Address Book Name is added to list");
    }
    public void displayAddressBook()
    {

        System.out.println("Existing AddressBook Names are : ");

        for (MultipleAddressBook addressBookList : addressBookList) {
            System.out.println(addressBookList);
        }
    }
    public void SearchCity() {
        System.out.println("Enter City name to search Person by city name");
        String userCity = scan.next();
        Dictionary DictCity = new Hashtable();
        ContactsBook.stream().filter(map -> map.getCity().contains(userCity)).forEach(ContactsBook ->
                System.out.println("Name of the City: " + userCity));
        for (Enumeration i = DictCity.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }
    public void SearchState()
    {
        System.out.println("Enter the state name to search Person by state name");
        String userState = scan.next();
        Dictionary DictState = new Hashtable();
        ContactsBook.stream().filter(map -> map.getState().contains(userState)).forEach(ContactsBook ->
                System.out.println("Name of the State: " + userState));
    }
    public void checkDuplicateName(String first)
    {
        for (int a = 0; a < ContactsBook.size(); a++)
        {
            String contactName = ContactsBook.get(a).FirstName;

            if (first.equals(contactName))
            {
                System.out.println("Person Name is already Exist");
            }
            else
            {
                System.out.println("Add Person");
                break;
            }
        }
    }
    public void DeletePersonFirstname()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter person first name: ");
        String name = scan.nextLine();

        for (int j = 0; j < ContactsBook.size(); j++)
        {
            String personName = ContactsBook.get(j).LastName;

            if (name.equals(personName))
            {
                ContactsBook.remove(j);
                System.out.println("Person Firstname is deleted");
                break;
            }
            else
                System.out.println("Please Enter Correct Name");
        }
    }
}