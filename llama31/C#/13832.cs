private bool IsPowerOfTwo(ulong number)\n{\n    return (number & (number - 1)) == 0 && number != 0;\n}