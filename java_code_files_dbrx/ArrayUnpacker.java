import java.lang.String;
public class ArrayUnpacker {
  double[] returnValues = calculateSomeDoubles();
  double firstVar   = returnValues[0];
  double secondVar = returnValues[1];

  public static void main(String[] args) {
  }

  public double[] calculateSomeDoubles() {
    return new double[] {1.0, 2.0};
  }
}