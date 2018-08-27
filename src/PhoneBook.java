import java.util.ArrayList;
import java.util.Scanner;

/**
 * phone book
 * taking number of contacts
 * adding them into an array list named phonebook
 * then get a last name and search for it
 * return the number .
 */
public class PhoneBook {
    private String lastName;
    private String firstName;
    private int phoneNumber;
    private String  phoneNumberType;
    static ArrayList<Contact> phoneBook = new ArrayList<Contact>();
    private Scanner readInput = new Scanner(System.in);

    /**
     * fill the phone book
     * get number & array list of contacts as
     * creates a contact
     * check whether the contact already exist ,decide if update or leave intact, or not so add id
     * then return the filled phone book
     */
    public void addContacts(int number) {
        Contact contact;
        boolean exist;
        for (int i = 0; i < number; i++) {
            System.out.print(" Name :");
            firstName = readInput.next();
            System.out.print(" lastName :");
            lastName = readInput.next();
            System.out.print(" Phone Number :");
            phoneNumber = readInput.nextInt();
            System.out.print(" Phone Number Type : \n-Mobile\n-Home\n-Fax \n:");
            phoneNumberType = readInput.next();
            contact = new Contact(firstName, lastName, phoneNumber,phoneNumberType);
            exist = false;
            for (Contact co : phoneBook) {
                if (co.getLastName().equals(contact.getLastName()) && co.getFirstName().equals(contact.getFirstName())) {
                    exist = true;
                    i--;
                    System.out.println("contact already exist");

                }
            }
            if (!exist)
                phoneBook.add(contact);
        }
        searchPhoneBook();
    }
    /**end of filling phone book*/

    public void editContact(){
        System.out.print("****** \n Plz enter the last name you're looking for :");
        lastName = readInput.next();

    }

    /**
     * infinite while loop taking last name and search for specified contact
     */
    public void searchPhoneBook() {

    while(true)
    {
        System.out.print("****** \n Plz enter the last name you're looking for :");
        lastName = readInput.next();
        searchLastNameInPhoneBook(lastName);    }
    /**end while*/
    }
    public void printNumbers(ArrayList<PhoneNumber> pns){
        for(PhoneNumber pn1 : pns){
            System.out.println(pn1.getNumType() +" : " +pn1.getNum());
        }

    }
    public void decision(Contact co ){
        int decision;
        System.out.print("enter 1 to Delete contact or 2 for Edit or add new number for current contact : ");
        decision = readInput.nextInt();
        switch (decision){
            case 1:
                phoneBook.remove(co);
                break;
            case 2:
                System.out.print(" Phone Number :");
                phoneNumber = readInput.nextInt();
                System.out.print(" Phone Number Type : \n-Mobile\n-Home\n-Fax \n:");
                phoneNumberType = readInput.next();
                co.addPhoneNumber(phoneNumber,phoneNumberType);
                break;
            default:
                System.out.print("invalid");
        }
    }
    /**search the phone book
     * taking last name and the phone book
     * count how many matching item is in the book then
     * if non, will return -1
     * if one then return the phone number
     * if more than one ,ask for first name to indicate desired one and call searchFirstNameInPhoneBook method
     */
    public void searchLastNameInPhoneBook(String lname) {
        int count=0;
        ArrayList<PhoneNumber> pns = new ArrayList<PhoneNumber>();
        for (Contact co : phoneBook) {
            if (co.getLastName().equals(lname))
                count++;
        }
        if (count==0)
            System.out.println("contact not found");
        else if(count==1){
            for (Contact co : phoneBook)
                if (co.getLastName().equals(lname)) {
                    pns= co.getPhoneNumbers();
                    printNumbers(pns);
                    decision(co);
                    break;
                }
        }
        else {
            String fn;
            System.out.print("multiple contact with last name \""+lname +"\" plz enter first name to indicate which one you want \n First Name: ");
            fn = readInput.next();
            searchFirstNameInPhoneBook(fn,lname);
        }

    }
    /** end of searchLastNameInPhoneBook*/
    /** search the phone book by first name
     * n case of having multiple contact with same last name
     * if having the contact with specified first&last name, return the number
     * if not, return -1
     * */
    public void searchFirstNameInPhoneBook(String fname,String lname) {
        ArrayList<PhoneNumber> pns = new ArrayList<PhoneNumber>();

        for (Contact co : phoneBook)
            if (co.getLastName().equals(lname) && co.getFirstName().equals(fname)){
                pns= co.getPhoneNumbers();
                printNumbers(pns);
                decision(co);
                break;
        }


    }

}
