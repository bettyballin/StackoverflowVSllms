#include <stdio.h>
#include <string.h>
#include <ctype.h>

void trim_and_convert(char *Org_arr, char *Conv_arr) {
    int i = 0, j = 0, k = 0;
    char temp[21];

    while (Org_arr[i] != '\0') {
        // Copy the next 20 characters to temp array
        strncpy(temp, Org_arr + i, 20);
        temp[20] = '\0'; // Null-terminate the temp array

        // Remove blank spaces from the temp array and add to Conv_arr
        for (k = 0; k < 20; k++) {
            if (temp[k] != '-') {
                Conv_arr[j++] = temp[k];
            }
        }

        // Add line feed at the end of each line
        Conv_arr[j++] = '\n'; // Changed '
' to '\n'

        // Move to the next block of 20 characters
        i += 20;
    }

    // Null-terminate the Conv_arr
    Conv_arr[j] = '\0';
}

int main() {
    char Org_arr[] = "1first line text------2second line text----3third line-------4--------------------5fith line text------";
    char Conv_arr[256]; // Ensure this is large enough to hold the converted text

    trim_and_convert(Org_arr, Conv_arr);

    printf("%s", Conv_arr);

    return 0;
}