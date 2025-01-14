#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void parse_form_data(char *data);

int main(void) {
    char *data;
    long len;
    printf("Content-Type: text/html\n\n");

    // Get the content length from the environment variable
    len = atol(getenv("CONTENT_LENGTH"));
    if (len <= 0) {
        printf("<p>Error: No data received</p>");
        return 1;
    }

    // Allocate memory for the data
    data = (char *)malloc(len + 1);
    if (!data) {
        printf("<p>Error: Unable to allocate memory</p>");
        return 1;
    }

    // Read the data from stdin
    if (fread(data, 1, len, stdin) != len) {
        printf("<p>Error: Unable to read data</p>");
        free(data);
        return 1;
    }
    data[len] = '\0'; // Null-terminate the string

    // Parse and process the form data
    parse_form_data(data);

    // Free the allocated memory
    free(data);

    return 0;
}

void parse_form_data(char *data) {
    char *token;
    char *rest = data;

    printf("<html><body>\n");
    printf("<h1>Rows to be deleted:</h1>\n");
    printf("<ul>\n");

    while ((token = strtok_r(rest, "&", &rest))) {
        char *key = strtok(token, "=");
        char *value = strtok(NULL, "=");

        if (key && value && strcmp(key, "row[]") == 0) {
            printf("<li>%s</li>\n", value);

            // Here you would add the logic to delete the row
            // For example, you could call a function to delete the row from the database
        }
    }

    printf("</ul>\n");
    printf("</body></html>\n");
}