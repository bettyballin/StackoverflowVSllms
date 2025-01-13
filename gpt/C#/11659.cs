public static double SquareRoot(double x) {\n    if (x < 0) throw new ArgumentOutOfRangeException(nameof(x), "Cannot compute square root of a negative number.");\n    if (x == 0) return 0;\n\n    double r = x;\n    double last;\n    double tolerance = 1e-10; // Tolerance value can be adjusted based on desired precision\n\n    do {\n        last = r;\n        r = (r + x / r) / 2;\n    } while (Math.Abs(r - last) > tolerance);\n\n    return r;\n}