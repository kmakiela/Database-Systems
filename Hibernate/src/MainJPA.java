import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainJPA {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();

        String categoryName1 = "owoce";
        String categoryName2 = "warzywa";

        String prod1Name = "winogrona";
        int prod1Stan = 500;
        String prod2Name = "agrest";
        int prod2Stan = 200;
        String prod3Name = "ogórek";
        int prod3Stan = 300;
        String prod4Name = "ziemniak";
        int prod4Stan = 20000;
        String prod5Name = "burak";
        int prod5Stan = 150;

        Category cat1 = new Category(categoryName1);
        Category cat2 = new Category(categoryName2);
        Product prod1 = new Product(prod1Name,prod1Stan);
        Product prod2 = new Product(prod2Name,prod2Stan);
        Product prod3 = new Product(prod3Name,prod3Stan);
        Product prod4 = new Product(prod4Name,prod4Stan);
        Product prod5 = new Product(prod5Name,prod5Stan);

        cat1.addProduct(prod1);
        cat1.addProduct(prod2);
        cat2.addProduct(prod3);
        cat2.addProduct(prod4);
        cat2.addProduct(prod5);
        em.persist(prod1);
        em.persist(prod2);
        em.persist(prod3);
        em.persist(prod4);
        em.persist(prod5);
        em.persist(cat1);
        em.persist(cat2);


        Product p1 = new Product("prod1",5000);
        Product p2 = new Product("prod2",3000);
        Set<Product> prodset= new HashSet<>(0);
        prodset.add(p1);
        prodset.add(p2);
        Invoice inv1 = new Invoice("inv1",2,prodset);
        em.persist(inv1);


        Customer cust1 = new Customer("Customer1","customerStreet","customerCity","666-666",15);
        Supplier supp1 = new Supplier("supplier1","supplierstreet","suppcity","66-666-66","12345676853256856");
        em.persist(cust1);
        em.persist(supp1);


        etx.commit();
        em.close();
    }
}