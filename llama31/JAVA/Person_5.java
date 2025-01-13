import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import java.util.List;

public class Person_5_5 {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "owner", orphanRemoval = true)
    private List<Bikes> bikes;

    public static void main(String[] args) {
    }
}