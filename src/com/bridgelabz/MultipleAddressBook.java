package com.bridgelabz;

public class MultipleAddressBook {
    public String userInputName;

    public MultipleAddressBook(String userInputName)
    {
        this.userInputName = userInputName;
    }
    public String getUserInputName()
    {
        return  userInputName;
    }
    public void setUserInputName(String FirstName)
    {
        this.userInputName = userInputName;
    }
    public String toString()
    {
        return "AddressBookName:" + userInputName + "\n";
    }
}
