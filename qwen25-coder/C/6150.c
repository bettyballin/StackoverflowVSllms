// Example of a simple program that has a memory leak\n#include <stdlib.h>\n\nvoid allocateMemory() {\n    int* leakedMemory = (int*)malloc(sizeof(int)); // Memory not freed\n}\n\nint main() {\n    for(int i = 0; i < 1000; i++) {\n        allocateMemory();\n    }\n    return 0;\n}