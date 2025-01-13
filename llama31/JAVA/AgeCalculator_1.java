import java.lang.String;
public class AgeCalculator_1 {
    public static void main(String[] args) {
        int birthYear = 2008;
        int birthMonth = 1;
        int birthDay = 1;
        calculateAge(birthYear, birthMonth, birthDay);
    }

    public static void calculateAge(int birthYear, int birthMonth, int birthDay) {
        // Get current date
        java.time.LocalDate currentDate = java.time.LocalDate.now();
        java.time.LocalDate birthDate = java.time.LocalDate.of(birthYear, birthMonth, birthDay);

        // Calculate years, months, and days
        long years = java.time.temporal.ChronoUnit.YEARS.between(birthDate, currentDate);
        long months = java.time.temporal.ChronoUnit.MONTHS.between(birthDate, currentDate) % 12;
        long days = java.time.temporal.ChronoUnit.DAYS.between(birthDate, currentDate) % 30;

        System.out.println(years + " years, " + months + " months, " + days + " days");
    }
}