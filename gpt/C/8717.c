void addint(Set *S, int n) {\n    (*S)[n/CHAR_SIZE] |= (unsigned char) pow(2, (CHAR_SIZE - 1) - (n % CHAR_SIZE));\n}