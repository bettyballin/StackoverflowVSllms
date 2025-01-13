#include <iostream>\n#include <sstream>\n#include <cstdio>\n\n// Create a custom FILE struct that writes to a std::stringstream\nstruct StringFile {\n    std::stringstream ss;\n};\n\n// Define a custom fwrite function for the StringFile struct\nsize_t stringFileWrite(void *ptr, size_t size, size_t nmemb, StringFile *file) {\n    file->ss.write((char*)ptr, size * nmemb);\n    return size * nmemb;\n}\n\n// Create a custom FILE pointer for the StringFile struct\nFILE *stringFilePtr(StringFile *file) {\n    static FILE f;\n    f._write = (int (*)(FILE *, const void *, int))stringFileWrite;\n    f._cookie = file;\n    return &f;\n}\n\nclass A {\npublic:\n    void print(FILE *f);\n    // ...\n};\n\nvoid A::print(FILE *f) {\n    std::string s = "stuff";\n    fprintf(f, "some %s", s.c_str());\n    // ...\n}\n\nint main() {\n    A a;\n    StringFile file;\n    FILE *f = stringFilePtr(&file);\n    a.print(f);\n    std::string result = file.ss.str();\n    std::cout << result << std::endl;\n    return 0;\n}