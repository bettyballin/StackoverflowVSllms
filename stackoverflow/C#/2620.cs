int[,] array = new int[4,4] {\n    { 1,2,3,4 },\n    { 5,6,7,8 },\n    { 9,0,1,2 },\n    { 3,4,5,6 }\n};\n\nint[,] rotated = RotateMatrix(array, 4);\n\nstatic int[,] RotateMatrix(int[,] matrix, int n) {\n    int[,] ret = new int[n, n];\n\n    for (int i = 0; i < n; ++i) {\n        for (int j = 0; j < n; ++j) {\n            ret[i, j] = matrix[n - j - 1, i];\n        }\n    }\n\n    return ret;\n}