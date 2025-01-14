#include <stdio.h>
#include <string.h>
#include <regex.h>

int main() {
    const char *input = "con*.cc";
    const char *pattern = "con.*.cc";
    const char *test_str = "con123.cc";
    
    regex_t regex;
    int ret;

    // Compile the regular expression
    ret = regcomp(&regex, pattern, REG_EXTENDED);
    if (ret) {
        fprintf(stderr, "Could not compile regex\n");
        return 1;
    }

    // Execute regular expression
    ret = regexec(&regex, test_str, 0, NULL, 0);
    if (!ret) {
        printf("Match\n");
    } else if (ret == REG_NOMATCH) {
        printf("No match\n");
    } else {
        char msgbuf[100];
        regerror(ret, &regex, msgbuf, sizeof(msgbuf));
        fprintf(stderr, "Regex match failed: %s\n", msgbuf);
        return 1;
    }

    // Free memory allocated to the pattern buffer by regcomp()
    regfree(&regex);

    return 0;
}