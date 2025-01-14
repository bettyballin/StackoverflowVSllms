#include <stdio.h>
#include <sys/stat.h>

int main() {
    struct stat attrib;
    if (stat("filename", &attrib) == 0) {
        unsigned long mtime = attrib.st_mtime; // last modification time
        printf("Last modification time: %lu\n", mtime);
    } else {
        printf("Failed to retrieve file attributes.\n");
    }
    return 0;
}