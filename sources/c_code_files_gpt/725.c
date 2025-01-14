#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>  // for read
#include <errno.h>   // for errno

void receive_file(int socket, char *save_to, int file_size) {
    FILE *handle = fopen(save_to, "wb");
    if (handle != NULL) {
        int SIZE = 1024;
        char buffer[SIZE];
        memset(buffer, 0, SIZE);
        int read_so_far = 0;
        int read_now = 0;
        int reading_unit = (file_size < SIZE) ? file_size : SIZE;

        while (read_so_far < file_size) {
            read_now = read(socket, buffer, reading_unit);
            if (read_now <= 0) {
                // Handle read error or end of file
                break;
            }
            fwrite(buffer, 1, read_now, handle);
            read_so_far += read_now;
            memset(buffer, 0, SIZE);
        }

        fclose(handle);
    } else {
        printf("Error creating file. Error code: %d\n", errno);
        exit(-1);
    }
}

int main() {
    // Add your code here to call the receive_file function
    return 0;
}