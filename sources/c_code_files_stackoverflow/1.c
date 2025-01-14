#include <stdio.h>
#include <procps.h>

int main(int argc, char *argv[]) {
    char buf[1024];
    proc_sysname(0, buf, 1024);
    printf("%s\n", buf);
    return 0;
}