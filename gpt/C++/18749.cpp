#include <iostream>\nusing namespace std;\n\nint main() {\n    int array[] = {1, 1, 2, 3, 4, 5, 6, 7, 8};\n    int count = sizeof(array) / sizeof(array[0]);\n    cout << "Count of elements in array: " << count << endl;\n    return 0;\n}