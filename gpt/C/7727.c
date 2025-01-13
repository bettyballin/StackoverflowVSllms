#include <stdio.h>\n#include <stdlib.h>\n\nvoid takes_a_long(long sad_story) {\n    printf("Long %lu\n", sad_story);\n}\n\nvoid takes_a_float(float my_boat) {\n    printf("Float %f\n", my_boat);\n}\n\nint main(int argc, char **argv) {\n    float my_boat = 1.0f;\n    long sad_story = 1.0L;\n\n    // No warnings wanted\n    takes_a_float(my_boat);\n    takes_a_long(sad_story);\n\n    // Suppress warnings for specific cases\n    #pragma GCC diagnostic push\n    #pragma GCC diagnostic ignored "-Wconversion"\n\n    // Warnings suppressed\n    takes_a_long(my_boat);\n    takes_a_float(sad_story);\n\n    // Re-enable warnings\n    #pragma GCC diagnostic pop\n\n    exit(0);\n}