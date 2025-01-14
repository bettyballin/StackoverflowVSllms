#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* RemoveTrailingZerosWrapper(float *f) {
    char buffer[20];
    snprintf(buffer, sizeof(buffer), "%.0f", *f);
    int len = strlen(buffer);
    while (len > 0 && buffer[len-1] == '0') { // remove trailing zeros if any.
        len--;
    }
    if (len > 0 && buffer[len - 1 ]== '.'){
       len -=1;
    }
    buffer[len]= '\0';
    return strdup(buffer); // Remember to free this result when you are done with it!
}

int main() {
    float f = 123.456;
    char* result = RemoveTrailingZerosWrapper(&f);
    printf("%s\n", result);
    free(result);
    return 0;
}