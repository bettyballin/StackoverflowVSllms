#include <stdio.h>
#include <string.h>

int main() {
    // Start ignoring tempnam warnings
    #pragma GCC diagnostic push
    #pragma GCC diagnostic ignored "-Wdeprecated-declarations"

        char dir_name[50];
        strcpy(dir_name, tempnam("/tmp", "myprefix"));
        *(strrchr(dir_name,'/'))='\0';
        printf("%s\n",dir_name);

    // Stop ignoring tempnam warnings
    #pragma GCC diagnostic pop
    return 0;
}