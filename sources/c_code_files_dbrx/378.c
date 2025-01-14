#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/stat.h>

int main(){
    char template[] = "/tmp/exampleXXXXXX";
    if (mkdtemp(template) == NULL){
        perror("mkdtemp");
        exit(EXIT_FAILURE);
    }
    printf("%s\n", template); // outputs "/tmp/exampleabcdef" or similar, with unique random suffix.
    return 0;
}