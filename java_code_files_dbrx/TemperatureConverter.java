import java.lang.String;
public class TemperatureConverter {
    /**
     * This method converts an Fahrenheit temperature to Celsius.
     * @param fahrenheit A double value representing the temperature in degrees Fahrenheit.
     * @return The equivalent temperature value as a double, expressed in degrees Celsius.
     */
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static void main(String[] args) {
    }
}