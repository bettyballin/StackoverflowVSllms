void CalcNewDimensions(ref int w, ref int h, int MaxWidth, int MaxHeight)\n{\n    // Calculate the aspect ratio of the image\n    double aspectRatio = (double)w / h;\n\n    // Calculate the maximum width and height while maintaining the aspect ratio\n    if ((double)w / MaxWidth > (double)h / MaxHeight)\n    {\n        w = MaxWidth;\n        h = (int)(w / aspectRatio);\n    }\n    else\n    {\n        h = MaxHeight;\n        w = (int)(h * aspectRatio);\n    }\n}