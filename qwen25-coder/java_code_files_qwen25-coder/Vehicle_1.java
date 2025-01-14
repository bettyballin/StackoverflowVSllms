import java.lang.String;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Vehicle_1 {

    @Entity
    @Table(name = "VEHICLE")
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    public abstract class Vehicle implements Serializable {

        @Id
        private int id;

        @Column(name = "NUM_WHEELS")
        private int numWheels;

        @Column(name = "COLOR")
        private String color;

        @Embedded
        private MovementData movementData;

        protected Vehicle() {
            // Default constructor
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumWheels() {
            return this.numWheels;
        }

        public void setNumWheels(int numWheels) {
            this.numWheels = numWheels;
        }

        public String getColor() {
            return this.color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public MovementData getMovementData() {
            return this.movementData;
        }

        public void setMovementData(MovementData movementData) {
            this.movementData = movementData;
        }
    }

    public static void main(String[] args) {
    }
}