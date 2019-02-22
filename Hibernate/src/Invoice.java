import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int invoiceID;

    private String InvoiceNumber;
    private int Quantity;

    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Product> Products = new HashSet<>(0);

    public Invoice(){

    }

    public Invoice(String invoiceNumber, int quantity) {
        InvoiceNumber = invoiceNumber;
        Quantity = quantity;
    }
    public Invoice(String invoiceNumber, int quantity, Set<Product> products ){
        InvoiceNumber = invoiceNumber;
        Quantity = quantity;
        Products = products;
    }


    public Set<Product> getProducts() {
        return Products;
    }

    public void addProduct(Product product) {
        Products.add(product);
        product.addToInvoice(this);
    }
}