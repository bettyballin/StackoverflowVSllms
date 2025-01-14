#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    FILE *file;
    long len;
    char *data, tmp[1024];

    /* Open the file */
    file = fopen("myfile", "r");
    if (!file) {
        fprintf(stderr, "Error opening file\n");
        exit(-1);
    }

    fseek(file, 0L, SEEK_END); // go to end of file for reading length
    len = ftell(file);         // get length size
    rewind(file);              // reset pointer to beginning

    /* Allocate memory for data */
    data = (char *)malloc((len + 1) * sizeof(char));
    if (!data) {
        fprintf(stderr, "Memory error\n");
        fclose(file);
        exit(-1);
    }

    /* Read in file content into the buffer */
    data[0] = '\0'; // Initialize data as an empty string
    while ((fgets(tmp, sizeof(tmp), file)) != NULL) {
        strcat(data, tmp);
    }

    fclose(file);             // close file pointer
    data[len] = '\0';         // null terminate string (not necessary, but left for consistency)

    free(data); // free allocated memory
    return 0;
}