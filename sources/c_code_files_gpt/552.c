#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main() {
    // Assuming data and connect_fd are defined elsewhere in the code
    struct {
        size_t size;
        unsigned char* data;
    } data;
    int connect_fd;

    // Initialize data and connect_fd
    // ...

    if (data.size > 0) {
        data.data = (unsigned char*)malloc(data.size);
        if (data.data == NULL) {
            // Handle memory allocation failure
            perror("malloc");
            exit(EXIT_FAILURE);
        }
        memset(data.data, 0, data.size);

        int remainingSize = data.size;
        unsigned char *iter = data.data;
        int count = 0;

        while (remainingSize > 0) {
            count = read(connect_fd, iter, remainingSize);
            if (count < 0) {
                // Handle read error
                perror("read");
                free(data.data);
                data.data = NULL;
                exit(EXIT_FAILURE);
            } else if (count == 0) {
                // Handle EOF
                break;
            }

            iter += count;
            remainingSize -= count;
        }

        if (remainingSize > 0) {
            // Handle incomplete read
            fprintf(stderr, "Incomplete read, expected %zu bytes but got %zu bytes\n", data.size, data.size - remainingSize);
            free(data.data);
            data.data = NULL;
            exit(EXIT_FAILURE);
        }
    } else {
        data.data = NULL;
    }

    return 0;
}