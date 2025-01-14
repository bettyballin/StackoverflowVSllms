#include <stdlib.h>
#include <stdio.h>
#include <time.h>

char* get_random_line(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (!file) return NULL; // check file exists and can be opened for reading!

    srand(time(NULL));  /* initialize random seed (may be done elsewhere in your program once) */
    int total_lines = rand() % RAND_MAX + 1, // use large number to avoid overflowing lines counter below
        line_count = 0;

    char *line = NULL, *selected_line = NULL;
    size_t len = 0;
    /* keep reading until we surpass total_lines or EOF reached */
    while(getline(&line, &len, file) != -1 && ++line_count <= total_lines){
        if (selected_line) free(selected_line); // free previous selected line
        if (rand() % line_count == 0) selected_line = strdup(line); // pick randomly with probability of being picked as equal among all lines up to now
        free(line);
        line = NULL; // reset line pointer
    }
    fclose(file);

    return selected_line;
}

int main() {
    char* random_line = get_random_line("test.txt");
    if (random_line) {
        printf("%s", random_line);
        free(random_line);
    } else {
        printf("Failed to read file or file is empty.\n");
    }
    return 0;
}