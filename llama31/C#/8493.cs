public static int EstimateCiphertextLength(int plaintextLength)\n{\n    int blocks = (plaintextLength + 15) / 16;\n    int ciphertextBytes = blocks * 16;\n    int base64Length = (ciphertextBytes + 2) / 3 * 4;\n    return base64Length;\n}