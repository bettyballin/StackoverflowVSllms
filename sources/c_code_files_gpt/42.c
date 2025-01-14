#include <fcntl.h>
#include <stdio.h>
#include <errno.h>
#include <unistd.h>

int main() {
    int file = open("example.txt", O_RDONLY);
    if (file == -1) {
        perror("Error opening file");
        return 1;
    }

    printf("size off_t: %zu\n", sizeof(off_t));

    off_t pos = lseek(file, (off_t)0, SEEK_CUR);
    if (pos == (off_t)-1) {
        perror("lseek error");
    } else {
        printf("pos: %lli\n", (long long)pos);
    }

    pos = lseek(file, (off_t)2352, SEEK_CUR);
    if (pos == (off_t)-1) {
        perror("lseek error");
    } else {
        printf("pos: %lli\n", (long long)pos);
    }

    close(file);
    return 0;
}