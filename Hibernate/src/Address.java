import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "street")
    private String StreetA;
    @Column(name = "city")
    private String CityA;


    public Address(){

    }

    public Address(String streetA, String cityA){
        this.StreetA = streetA;
        this.CityA = cityA;
    }

    public String getStreetA() {
        return StreetA;
    }

    public void setStreetA(String streetA) {
        StreetA = streetA;
    }

    public String getCityA() {
        return CityA;
    }

    public void setCityA(String cityA) {
        CityA = cityA;
    }
}