#include <dirent.h>
#include <stdio.h>

int main() {
    DIR *directory = opendir("/path/to/directory"); // Open directory (replace with your path)
    struct dirent *entry;
    if(directory != NULL){
        while((entry = readdir(directory)) != NULL){
            printf("%s\n", entry->d_name);
        }
        closedir(directory); // Don't forget to close the directory stream!
    } else {
        perror("Could not open directory");
    }
    return 0;
}