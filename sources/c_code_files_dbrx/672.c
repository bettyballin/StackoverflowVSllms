#include <stdio.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <string.h>

void print_output(char *command) {
    size_t max = 4096; // Maximum output length, for example
    char buffer[max];   // Buffer to store command's output
    FILE* file;          // File to execute the shell-command in a subprocess

    /* open pipe and execute shell command */
    if ((file = popen(command, "r")) == NULL) {
        perror("popen");
        exit(EXIT_FAILURE);
    }

    /* capture output */
    while (fgets(buffer, max-1, file)) {
        printf("%s", buffer); // print directly or store for processing etc.
    }

    if ((pclose(file)) == -1)  perror("pclose");
}

int main() {
   char command[4096]="ls"; /* Replace with your desired command */
   strcat(command," ");
   strncat(command, "/etc",strnlen("/etc",400)); /* Directory to list files in the example */
   print_output(command);
   return EXIT_SUCCESS;
}