// Original struct definition\ntypedef struct {\n    int id;\n    char name[50];\n} UserOriginal;\n\n// New version of the struct with an additional field at the end\ntypedef struct {\n    int id;\n    char name[50];\n    float balance; // new field added\n} UserUpdated;