void processArray(int array[], int size) {\n    for (int i = 0; i < size; i++) {\n        // Process each element\n        printf("%d\n", array[i]);\n    }\n}\n\nint main() {\n    int array[] = {1, 2, 3, 4, 5};\n    int size = sizeof(array) / sizeof(array[0]); // Calculate size in the caller\n    processArray(array, size);\n    return 0;\n}