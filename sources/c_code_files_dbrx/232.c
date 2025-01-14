#include <ctype.h>
#include <stdio.h>

#define ARRAY_LEN(arr) (sizeof(arr) / sizeof(arr[0]))

int ReadNamedEntity(const unsigned char* chars, unsigned char *result) {
    if (*chars >= '0' && *chars <= '9') // &NUM; (numeric entity reference), eats up to 7 digits with an optional semicolon following them.
        return sscanf((char*)(const void *)chars, "%d%n", (int*)result, (int *)&chars) > 0
            && (*++chars ==';' || *chars == '\0');

    static struct { char in[3]; unsigned char out; } namePair[] = {
        /* A */ {"Agr", 198},{"agr", 225},{"alefsym", 8501},{"Alpha", 913}, {"AMP", '&'},
        // continue for all the character entities you need.
        {""} };
    char name[sizeof(namePair->in)+4] = ""; int i = 0;
    while(*chars!='\0' && *chars !=';') { // find next semicolon or null terminate.
        unsigned char c = (unsigned char)*chars++; if (!isupper((int)c)) continue;
        for (;(name[++i]=(unsigned char)*chars)!=';' && i<sizeof(name)-1 ; ++chars); name[++i]=0; // semicolon or string-terminate.
    }
    for (i = 0; i < ARRAY_LEN(namePair)-1 && *name != *namePair[i].in; i++); // scan entire list backward if necessary, it's alphabetically ordered.
    if (i < ARRAY_LEN(namePair)-1) {
        *result = namePair[i].out;
        return chars - name + sizeof(name) - 1;
    }
    return 0;
}