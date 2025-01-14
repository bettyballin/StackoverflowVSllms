#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h> // added for printf and perror
#include <errno.h> // added for perror

int main() {
    const char *filename = "/tmp/myfile";
    int fd;

    /* The mask used here limits the permissions set for the file to 666 (rw-rw-rw-) */
    umask(0); // reset the user mask so that no unwanted bits get set in mode argument below.
    if ((fd = open(filename, O_CREAT | O_WRONLY, S_IRUSR|S_IWUSR|S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH)) < 0) {
        perror("Couldn't create or write to file.");  // handle error here
    } else {
        /* close file descriptor */
        if(close(fd)<0){
            perror("Failed to close the file.");  //handle the error appropriately
        }else{
            printf("File created successfully with all permissions.\n");
        }
    }
    return (0);
}