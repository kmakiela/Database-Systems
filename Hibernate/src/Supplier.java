import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Supplier extends Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int supplierID;
    private String bankAccountNumber;

    public Supplier(){

    }

    public Supplier(String companyName, String street, String city, String zipCode, String bankAccountNumber) {
        super(companyName, street, city, zipCode);
        this.bankAccountNumber = bankAccountNumber;
    }
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

}