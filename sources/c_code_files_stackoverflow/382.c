#include <unistd.h>
#include <string.h>

int main() {
    const char *buf = "Hello, World!";
    size_t count = strlen(buf);
    ssize_t bytes_written;

    bytes_written = write(STDOUT_FILENO, buf, count);

    if (bytes_written != count) {
        write(STDERR_FILENO, "Error writing to standard output.\n", 31);
        return 1;
    }

    return 0;
}