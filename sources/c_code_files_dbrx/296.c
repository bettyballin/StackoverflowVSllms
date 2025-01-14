#include <unistd.h>

int main() {
    int fileDescriptor = 0; // replace with your actual file descriptor
    off_t newSize = 0; // replace with your actual new size

    lseek(fileDescriptor, 0, SEEK_SET);
    ftruncate(fileDescriptor, newSize);

    return 0;
}