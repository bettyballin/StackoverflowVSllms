import java.util.Calendar;
import java.util.Date;

public class AgeCalculator {
    public static int calculateAge(Date birthDate) {
        int age = 0;
        Calendar today = Calendar.getInstance();
        if (birthDate != null) {
            Calendar born = Calendar.getInstance();
            born.setTime(birthDate);
            if (today.get(Calendar.MONTH) >= born.get(Calendar.MONTH) && 
                today.get(Calendar.DAY_OF_MONTH) >= born.get(Calendar.DAY_OF_MONTH)) {
                age = today.get(Calendar.YEAR) - born.get(Calendar.YEAR);
            } else {
                age = today.get(Calendar.YEAR) - born.get(Calendar.YEAR) - 1;
            }
        }
        return age;
    }

    public static void main(String[] args) {
        // Example usage:
        Date birthDate = new Date(100, 0, 1); // January 1, 2000
        int age = calculateAge(birthDate);
        System.out.println("Age: " + age);
    }
}