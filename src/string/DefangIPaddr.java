package string;

public class DefangIPaddr {
    public String defangIPaddr(String address) {

        return address.replace(".", "[.]");
    }
}