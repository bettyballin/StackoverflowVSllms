#include <stdio.h>
#include <stdlib.h>

int main () {
    char source_file[] = "/path/to/source/file"; // replace with your source file
    char destination_path[] = "/path/to/destination"; // replace with your destination path
    char command[50];
    sprintf(command, "rsync --inplace -a %s user@server:%s", source_file, destination_path);
    system(command);
    return 0;
}