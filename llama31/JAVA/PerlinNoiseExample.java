import java.lang.String;

public class PerlinNoiseExample {
  public static void main(String[] args) {
    int octaves = 6;
    double persistence = 0.5;
    double lacunarity = 2.0;

    PerlinNoise noise = new PerlinNoise(octaves, persistence, lacunarity);

    // Generate a 2D array of noise values
    int width = 256;
    int height = 256;
    double[][] noiseValues = new double[width][height];
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        double noiseValue = noise.noise(x / 10.0, y / 10.0);
        noiseValues[x][y] = noiseValue;
      }
    }

    // Use the noise values to generate a texture, or for any other purpose...
  }
}

// You were missing the PerlinNoise class
class PerlinNoise {
  private int octaves;
  private double persistence;
  private double lacunarity;

  public PerlinNoise(int octaves, double persistence, double lacunarity) {
    this.octaves = octaves;
    this.persistence = persistence;
    this.lacunarity = lacunarity;
  }

  public double noise(double x, double y) {
    double amplitude = 1.0;
    double frequency = 1.0;
    double value = 0.0;

    for (int i = 0; i < octaves; i++) {
      value += amplitude * noiseOctave(x * frequency, y * frequency);
      amplitude *= persistence;
      frequency *= lacunarity;
    }

    return value;
  }

  private double noiseOctave(double x, double y) {
    int x0 = (int) Math.floor(x);
    int y0 = (int) Math.floor(y);
    int x1 = x0 + 1;
    int y1 = y0 + 1;

    double sx = x - x0;
    double sy = y - y0;

    double n0 = noiseGrad(x0, y0, sx, sy);
    double n1 = noiseGrad(x1, y0, sx - 1, sy);
    double n2 = noiseGrad(x0, y1, sx, sy - 1);
    double n3 = noiseGrad(x1, y1, sx - 1, sy - 1);

    double nx0 = interpolate(n0, n1, sx);
    double nx1 = interpolate(n2, n3, sx);

    return interpolate(nx0, nx1, sy);
  }

  private double noiseGrad(int x, int y, double sx, double sy) {
    int random = x * 57 + y * 133;
    int gradients = 4;
    int gradient = (random % gradients);

    switch (gradient) {
      case 0:
        return  sx + sy;
      case 1:
        return -sx + sy;
      case 2:
        return  sx - sy;
      case 3:
        return -sx - sy;
      default:
        return 0;
    }
  }

  private double interpolate(double a, double b, double x) {
    double ft = x * 3.1415927;
    double f = (1 - (float) Math.cos(ft)) * 0.5;

    return a * (1 - f) + b * f;
  }
}