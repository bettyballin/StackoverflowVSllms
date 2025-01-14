#include <unistd.h>
#include <sys/syscall.h>
#include <linux/random.h>
#include <stdio.h> // For printf

int get_random_bytes(void *buf, size_t buflen) {
    return syscall(SYS_getrandom, buf, buflen, 0);
}

int main() {
    char buf[16];
    ssize_t bytes_received = get_random_bytes(buf, sizeof(buf));
    if (bytes_received < 0) {
        perror("get_random_bytes failed");
        return 1; // Return with an error code
    }

    printf("Received %zd random bytes:\n", bytes_received);
    for (size_t i = 0; i < bytes_received; ++i) {
        printf("%02x ", (unsigned char)buf[i]);
    }
    printf("\n");

    return 0;
}