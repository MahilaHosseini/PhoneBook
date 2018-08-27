import java.util.ArrayList;

/**
 * Created by lenovo.com on 2/20/2018.
 * contact class
 * having first & last name and a phone number
 */
public class Contact {

    private String firstName;
    private String lastName;
    private ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
    private PhoneNumber pn;


    public Contact(String fname, String lname, int phoneNumber, String ntype) {
        this.firstName = fname;
        this.lastName = lname;
        this.pn=new PhoneNumber(ntype, phoneNumber);
        this.phoneNumbers.add(pn);
    }

    public ArrayList<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addPhoneNumber(int phoneNumber,String ntype) {
        boolean newNumber=true;
        for (PhoneNumber pn1 : phoneNumbers) {
            if (pn1.getNumType().equalsIgnoreCase(ntype)){
                pn1.setNum(phoneNumber);
                newNumber=false;
                break;
            }
        }
        if(newNumber){
            this.pn = new PhoneNumber(ntype, phoneNumber);
            this.phoneNumbers.add(pn);
        }


    }
}


