#include <stdio.h>\n\nstatic double inner_function(double x, void* params) {\n    // some code\n    return x*x;\n}\n\ndouble some_function(double x, double y) {\n    double z;\n    z = inner_function(x, NULL);\n    return z+y;\n}\n\nint main(void) {\n    printf("%f\n", some_function(2.0, 4.0));\n    return 0;\n}