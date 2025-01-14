#include <fcntl.h>

int main() {
    int fd_out;
    char *PIPE_OUT = "/path/to/your/pipe"; // replace with your actual pipe path
    fd_out = open(PIPE_OUT, O_WRONLY | O_NDELAY); // Open the pipe in non-blocking write mode
    return 0;
}