int nextPowerOfTwo(int value) {\n    if (value == 0) return 1;\n    --value;\n    value |= value >> 1;\n    value |= value >> 2;\n    value |= value >> 4;\n    value |= value >> 8;\n    value |= value >> 16;\n    return value + 1;\n}