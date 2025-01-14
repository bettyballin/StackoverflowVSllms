#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <iostream>
#include <fstream>

int main() {
    char *tmpname = strdup("/tmp/tmpfileXXXXXX");
    std::ofstream f;
    int fd = mkstemp(tmpname);
    f.attach(fd);
    // You may want to add error checking and handling code here
    free(tmpname);
    return 0;
}