void preprocessTexture(unsigned char* data, int width, int height, int lower, int upper) {\n    for (int i = 0; i < width * height * 3; ++i) {\n        if (data[i] < lower) data[i] = 0;\n        else if (data[i] > upper) data[i] = 255;\n        else data[i] = ((data[i] - lower) * 255) / (upper - lower);\n    }\n}\n\n// Load and preprocess your texture data\npreprocessTexture(textureData, textureWidth, textureHeight, lowerBound, upperBound);