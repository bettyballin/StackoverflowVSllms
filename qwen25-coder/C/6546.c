void callFunctionByName(const char* name) {\n    for (int i = 0; i < numFunctions; i++) {\n        if (strcmp(name, functionNames[i]) == 0) {\n            functions[i]();\n            return;\n        }\n    }\n    printf("Function not found.\n");\n}