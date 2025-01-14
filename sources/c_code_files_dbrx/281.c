#include <unistd.h>

int main() {
    int fileDescriptor = /* replace with your file descriptor */;
    off_t newSize = /* replace with your new size */;

    int result = ftruncate(fileDescriptor, newSize);

    return result;
}