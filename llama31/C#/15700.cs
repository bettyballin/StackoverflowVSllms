double sqrt(double x)\n{\n    bool goodEnough(double guess) => Math.Abs(square(guess) - x) < 0.001;\n    double improve(double guess) => average(guess, x / guess);\n    double sqrtIter(double guess) => goodEnough(guess) ? guess : sqrtIter(improve(guess));\n\n    return sqrtIter(1.0);\n}