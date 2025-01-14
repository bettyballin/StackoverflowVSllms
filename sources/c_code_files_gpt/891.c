#include <stdio.h>
#include <stdlib.h>

int main() {
    char *buffer;
    size_t bufsize = 32;
    size_t characters;

    buffer = (char *)malloc(bufsize * sizeof(char));
    if (buffer == NULL) {
        perror("Unable to allocate buffer");
        exit(1);
    }

    printf("Enter a line of text:\n");
    characters = getline(&buffer, &bufsize, stdin);
    printf("You entered: %s", buffer);

    free(buffer);
    return 0;
}