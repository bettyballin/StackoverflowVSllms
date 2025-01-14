#include <stdio.h>
#include <string.h>
#include <ctype.h>

void trim_and_feed(char org_arr[], char conv_arr[]) {
    int src = 0, dst = 0; // Source and destination indices for copying
    const int BUFSIZE = strlen(org_arr); // Buffer size of the source array
    char *line_start = strtok(org_arr, "1"); // Split lines by control codes (0, 1, ...)

    while (line_start != NULL) { // Continue until no more lines are found in org_array[]
        for (int i = 0; line_start[i] != '\0'; ++i) { // Iterate through characters within each line
            if (!isspace(line_start[i])) { // Skip spaces and keep non-space chars
                conv_arr[dst++] = line_start[i];
            } else if (i > 0 && !isspace(line_start[i - 1])){
                // Add only one space after each word for readability.
                conv_arr[dst] = ' ';
                dst++;
            }
        }

        conv_arr[dst++] = '\n'; // Append line feed at the end of the current line
        line_start = strtok(NULL, "1"); // Get the next available line to process
    }
    conv_arr[dst] = '\0'; // Null-terminate the output string
}

int main() {
    char org_arr[] = "0 fi rs tl inet ext----------1 seco ndline  text----------2 third--lin e-------------
"; // Example input array with control codes and '-' for spaces
    const int NEW_BUFFERSIZE = 3 * strlen(org_arr); // To account for added line feeds and potential word lengthening. Adjust if needed.
    char conv_arr[NEW_BUFFERSIZE];
    trim_and_feed(org_arr, conv_arr);
    printf("%s", conv_arr); // Print the output with trimmed spaces and line feeds at the end of each non-empty line.
    return 0;
}