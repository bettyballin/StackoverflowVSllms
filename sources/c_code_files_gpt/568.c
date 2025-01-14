#include <unistd.h>
#include <fcntl.h>

ssize_t my_pread(int fd, void *buf, size_t count, off_t offset) {
    off_t old_offset = lseek(fd, 0, SEEK_CUR);
    if (old_offset == (off_t) -1) {
        return -1;
    }
    if (lseek(fd, offset, SEEK_SET) == (off_t) -1) {
        return -1;
    }
    ssize_t result = read(fd, buf, count);
    if (lseek(fd, old_offset, SEEK_SET) == (off_t) -1) {
        return -1;
    }
    return result;
}

int main() {
    // You can test the function here
    return 0;
}