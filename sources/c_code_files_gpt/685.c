#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_LINE_LENGTH 256

// Function to count the number of lines in the file
int count_lines(FILE *file) {
    int count = 0;
    char line[MAX_LINE_LENGTH];

    while (fgets(line, sizeof(line), file)) {
        count++;
    }

    return count;
}

// Function to get a random line from the file
char* get_random_line(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (!file) {
        perror("Unable to open file");
        return NULL;
    }

    // Count the number of lines in the file
    int num_lines = count_lines(file);
    if (num_lines == 0) {
        fclose(file);
        return NULL;
    }

    // Generate a random line number
    srand(time(NULL));
    int random_line = rand() % num_lines;

    // Reset file pointer to the beginning
    rewind(file);

    // Read up to the randomly chosen line
    char *line = malloc(MAX_LINE_LENGTH);
    if (!line) {
        perror("Unable to allocate memory");
        fclose(file);
        return NULL;
    }

    for (int i = 0; i <= random_line; i++) {
        if (!fgets(line, MAX_LINE_LENGTH, file)) {
            free(line);
            fclose(file);
            return NULL;
        }
    }

    fclose(file);
    return line;
}

int main() {
    const char *filename = "yourfile.txt";
    char *random_line = get_random_line(filename);

    if (random_line) {
        printf("Random line: %s", random_line);
        free(random_line);
    } else {
        printf("No line found or error occurred.\n");
    }

    return 0;
}