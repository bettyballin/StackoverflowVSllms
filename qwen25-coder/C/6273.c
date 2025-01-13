int countSetBits(int n) {\n    int count = 0;\n    while (n) {\n        n &= (n - 1); // Turn off the rightmost set bit\n        count++;\n    }\n    return count;\n}