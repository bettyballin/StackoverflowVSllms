int Wrap(int const kX, int const kLowerBound, int const kUpperBound)\n{\n    int range = kUpperBound - kLowerBound + 1;\n    int wrappedValue = (kX - kLowerBound) % range;\n    if (wrappedValue < 0)\n        wrappedValue += range;\n    return wrappedValue + kLowerBound;\n}