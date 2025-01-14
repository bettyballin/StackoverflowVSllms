#include <stdio.h>

#define STR(s) s
#define M(x, y) x = STR(y),

enum {
    #define APPENDARRAY(name_symbl, name_strng)  M(name_symbl, name_strng)
       APPENDARRAY(STR_YES, "yes")
       APPENDARRAY(STR_NO, "no")
       APPENDARRAY(STR_MAYBE, "maybe")
       APPENDARRAY(NUMBER_OF_STRINGS, "dummy") // Needed to define NUMBER_OF_STRINGS
    #undef APPENDARRAY
};

const char *strings[] = {
       STR("yes"),
       STR("no"),
       STR("maybe")
};

int main() {
    printf("Strings:\n");
    for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
        printf("%s\n", strings[i]);
    }
    return 0;
}