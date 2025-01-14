#include <stdio.h>
#include <sys/stat.h>

int main() {
    const char *path = "/home/shree/path/def";
    struct stat path_stat;
    
    if (stat(path, &path_stat) != 0) {
        perror("stat");
        return 1;
    }
    
    if (S_ISDIR(path_stat.st_mode)) {
        printf("%s is a directory\n", path);
    } else if (S_ISREG(path_stat.st_mode)) {
        printf("%s is a file\n", path);
    } else {
        printf("%s is neither a regular file nor a directory\n", path);
    }
    
    return 0;
}