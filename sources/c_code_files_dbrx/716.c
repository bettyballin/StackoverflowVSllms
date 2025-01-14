#include <stdio.h>
#include <regex.h>
#include <string.h>

int main(void) {
    const char *pattern = "con*.cc";
    regex_t regex;
    int reti = regcomp(&regex, pattern, REG_EXTENDED);
    if (!reti) {
        const char *strings[] = {"connections.cc", "constructions.cpp"};
        for (size_t i=0; i < sizeof(strings)/sizeof(*strings); ++i){
            reti = regexec(&regex, strings[i], 0, NULL, 0);
            if (!reti) {
                printf("%s matches\n", strings[i]);
            } else if (reti == REG_NOMATCH) {
                printf("%s does not match\n", strings[i]);
            }
        }
    }
    regfree(&regex);
    return 0;
}