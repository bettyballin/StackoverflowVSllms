#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>

#define BUFFER_SIZE 1024

void tail_f(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (!file) {
        perror("fopen");
        exit(EXIT_FAILURE);
    }

    // Seek to the end of the file
    fseek(file, 0, SEEK_END);

    while (1) {
        struct stat st;
        if (stat(filename, &st) == -1) {
            perror("stat");
            exit(EXIT_FAILURE);
        }

        // If the file has grown
        if (ftell(file) < st.st_size) {
            char buffer[BUFFER_SIZE];
            while (fgets(buffer, sizeof(buffer), file)) {
                // Process the line (for now, just print it)
                printf("%s", buffer);
            }
        } else {
            // Sleep for a short duration before checking again
            usleep(500000); // 500 milliseconds
        }
    }

    // This will never be reached due to the infinite loop
    // fclose(file); // Commented out to avoid unreachable code warning
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <logfile>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    tail_f(argv[1]);

    return 0;
}