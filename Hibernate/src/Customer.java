import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Customer extends Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int customerID;
    public double discount;

    public Customer(){

    }

    public Customer(String companyName, String street, String city, String zipCode, float discount) {
        super(companyName, street, city, zipCode);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }


}