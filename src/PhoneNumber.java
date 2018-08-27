

/**
 * phone number class
 */
public class PhoneNumber {
    public enum Ntype{
        MOBILE,
        HOME,
        FAX
    }

    Ntype numType;
    int num;

    public PhoneNumber(String ntype, int num) {
        switch (ntype.toLowerCase()){
            case "mobile":
                this.numType = Ntype.MOBILE;
                break;
            case "home":
                this.numType = Ntype.HOME;
                break;
            case "fax":
                this.numType = Ntype.FAX;
                break;
            default:
                System.out.println("invalid");

        }

        this.num = num;
    }

    public void setNum(int num ) {
        this.num = num;
    }

    public String getNumType() {

        switch (this.numType){
            case MOBILE:
                return "Mobile" ;
            case HOME:
                return "Home";
            case FAX:
                return "Fax";
            default:
                return null;
        }
    }

    public int getNum() {
        return num;
    }
}
