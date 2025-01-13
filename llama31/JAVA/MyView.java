import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "my_view")
@IdClass(MyViewPK.class)
public class MyView {
    @Id
    @Column(name = "column1")
    private String column1;

    @Id
    @Column(name = "column2")
    private String column2;

    // getters and setters
    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }
}

public class MyViewPK implements Serializable {
    private String column1;
    private String column2;

    // getters and setters
    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((column1 == null) ? 0 : column1.hashCode());
        result = prime * result + ((column2 == null) ? 0 : column2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyViewPK other = (MyViewPK) obj;
        if (column1 == null) {
            if (other.column1 != null)
                return false;
        } else if (!column1.equals(other.column1))
            return false;
        if (column2 == null) {
            if (other.column2 != null)
                return false;
        } else if (!column2.equals(other.column2))
            return false;
        return true;
    }

    public static void main(String[] args) {
    }
}