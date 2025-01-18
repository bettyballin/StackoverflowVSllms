import java.lang.String;
public class Circle_2 {
     private double radius;
     private double PI = 3.14159;

     public void setRadius(double rad) {    // <-- typo was here
             radius = rad;
     }

     public double getRadius() {
             return radius;
     }

     public double getArea() {
        if (radius != 0){         // check that the radius is not initialised to zero or not set yet.
            return PI * radius * radius;
        } else{
            System.out.println("Error: Radius needs to be configured.");
             return -1 ;
           }
     }

    public double getDiameter() {   // <-- typo was in the method name, 'getDiame' should have been 'getDiamet',
        if (radius != 0){          // I've changed it to 'getDiameter'.
            return 2 * radius;
         } else{
             System.out.println("Error: Radius needs to be configured.");
              return -1 ;
           }
    }

     public double getCircumference() { // <-- typo was in the method name, 'getCircu' should have been 'getCircum', I've changed it to 'getCircumference'.
         if (radius != 0){          // check that the radius is not initialised to zero or not set yet.
            return 2 * PI * radius;
        } else{
            System.out.println("Error: Radius needs to be configured.");
             return -1 ;
           }
      }

	public static void main(String[] args) {
	}
}