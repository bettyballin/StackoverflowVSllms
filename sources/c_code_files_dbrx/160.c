#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

// Run hwclock command to update system and hardware clocks from each other or a provided time.
int set_hardware_clock(const char *command) {
    int ret = -1;
    if (setuid(0)) {  // Switching the effective UID/GID of the process. This should be done with care as it can lead to privilege escalations.
        perror("setuid");
        return -1;
    }

    ret = system(command);
    if (ret) {
        fprintf(stderr, "Command failed:\n%s\n", command);
    }

    setuid(geteuid());  // Resetting the UID/GID to what it was before setuid() is a good practice.
    return ret;
}

// Set hardware clock from current system time. Use UTC if hwclock doesn't support auto-detection of local vs UTC or for safety (to avoid bugs in BIOS or driver).
int main(void) {
   int ret = set_hardware_clock("hwclock --hctosys  --systohc && exit");
   return ret;
}