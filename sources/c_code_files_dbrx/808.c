#include <fcntl.h> // For O_RDONLY (open flags) and ftruncate() function prototypes
#include <unistd.h> // For open() function prototype
#include <stdio.h> // For perror() function
#include <stdlib.h> // For exit() function and EXIT_FAILURE macro

int main(void){
    int fd;
    char *filename = "./test.txt"; /* Replace with your filename */
    off_t newsize = 1024*256 ; /* Length file will be set to */

    fd = open(filename, O_RDONLY|O_TRUNC); /* Open existing file in read-only mode and truncate it */

    if (fd != -1){
        ftruncate(fd, newsize ); /* Set the length of file to 'newsize' bytes */
        close (fd) ; /* Close the file descriptor before exiting.*/
    } else{
        perror("open failed"); 
        exit(EXIT_FAILURE);
    }
    return 0;
}