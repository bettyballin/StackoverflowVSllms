// mylib.c\n#include <stdio.h>\n#include <dlfcn.h>\n\nvoid lib_function() {\n    void* handle = dlopen(NULL, RTLD_LAZY); // Get the handle of the main program\n    void (*my_func)() = dlsym(handle, "my_function");\n    if (my_func) {\n        my_func(); // Call the function in the main program\n    }\n    dlclose(handle);\n}