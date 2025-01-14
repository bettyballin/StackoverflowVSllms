#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <errno.h>

int main() {
    uid_t ruid, euid, suid;

    // Get the real, effective, and saved UIDs
    if (getresuid(&ruid, &euid, &suid) == -1) {
        perror("getresuid");
        return 1;
    }

    printf("Real UID: %d\n", ruid);
    printf("Effective UID: %d\n", euid);
    printf("Saved UID: %d\n", suid);

    return 0;
}