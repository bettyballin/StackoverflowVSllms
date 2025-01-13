void inverseTrilinearInterpolation(float v000, float v100, float v110, float v010, \n                                   float v001, float v101, float v111, float v011, \n                                   float value, float* x, float* y, float* z) {\n  float temp1 = v000 * (1 - value) + v001 * value;\n  float temp2 = v100 * (1 - value) + v101 * value;\n  float temp3 = v010 * (1 - value) + v011 * value;\n  float temp4 = v110 * (1 - value) + v111 * value;\n\n  *y = (temp1 * (temp4 - temp2) - temp3 * (temp2 - temp1)) / ((temp4 - temp2) * (temp3 - temp1) * (temp2 - temp1));\n  if (*y < 0 || *y > 1) {\n    // Handle out-of-bounds y value\n  }\n\n  *x = (temp1 * (temp3 - temp4) - temp2 * (temp3 - temp1)) / ((temp3 - temp4) * (temp2 - temp1) * (temp4 - temp2));\n  if (*x < 0 || *x > 1) {\n    // Handle out-of-bounds x value\n  }\n\n  *z = (value - temp1) / (v001 - v000);\n  if (*z < 0 || *z > 1) {\n    // Handle out-of-bounds z value\n  }\n}