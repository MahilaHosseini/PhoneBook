import java.util.Scanner;

/**
 * Created by lenovo.com on 3/4/2018.
 */
public class PhoneMain {
    public static void main(String[] args) {
        PhoneBook phoneBook1 = new PhoneBook();
        int numberOfContacts;
        Scanner readInput = new Scanner(System.in);


        System.out.println(" plz enter number of contacts ");
        numberOfContacts = readInput.nextInt();
        phoneBook1.addContacts(numberOfContacts);


    }
}
