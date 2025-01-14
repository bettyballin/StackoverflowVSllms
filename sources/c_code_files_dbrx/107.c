#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *StringPadRight(const char *src, int pad_len, const char pad) {
    // source string length
    size_t len = strlen(src);

    // if the padded length is less than or equal to the original length, return its copy.
    if (pad_len <= len) {
        char *buf = malloc(len+1);  /* +1 for null terminator */
        strcpy(buf, src);           /* make a copy as 'memcpy' does not append NULL character */
        return buf;                 /* return copied string when padded length is same or less than original length */
    } else {
        // allocates space for the final dest with padding count of 1-byte characters plus null terminator.
        char *buf =(char*) malloc(pad_len+1); /* +1 for null terminator*/
        strcpy(buf, src);            /* copy original string in buf */

        // Append pad character to create padded length of the string.
        memset(buf + len, pad, pad_len - len);  /* sets the rest of spaces by pad character */
        buf[pad_len] = '\0';               /* set end null terminator position for created space */
        return buf;                    /* returns padded character array (string) */
    }
}

int main() {
    char *str = StringPadRight("Hello", 10, ' ');
    printf("%s\n", str);
    free(str);
    return 0;
}