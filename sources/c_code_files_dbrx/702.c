#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>

off_t get_file_size(const char *filename) {
    struct stat st;

    if (stat(filename, &st) == 0)
        return st.st_size;

    return -1;
}

int main() {
    const char *filename = "example.txt";
    off_t fsize = get_file_size(filename);

    if (fsize != -1)
        printf("The size of file '%s' is %lld bytes.\n", filename, (long long)fsize);
    else
        printf("Failed to get the size of file '%s'.\n", filename);

    return 0;
}