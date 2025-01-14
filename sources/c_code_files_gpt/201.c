#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <stdio.h>

int main() {
    const char *fileName = "/tmp/myfile.txt";
    int fd = open(fileName, O_CREAT | O_RDWR, 0666);
    
    if (fd == -1) {
        perror("Error creating file");
        return 1;
    }
    
    close(fd);
    return 0;
}