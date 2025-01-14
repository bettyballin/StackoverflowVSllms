#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdbool.h> // for bool type

bool is_directory(const char *path) {
    struct stat sb;
    if (stat(path, &sb) == -1) 
        return false;

    int dir_bit = S_IFDIR; 
#ifdef _S_IREAD  
     dir_bit = S_IFDIR;
#endif
    if ((sb.st_mode & dir_bit) != 0) {
        return true;
    } else {
        return false;
    }
}

int main() {
    // Example usage:
    const char *path = "/path/to/directory";
    if (is_directory(path)) {
        return 0; // Directory exists
    } else {
        return 1; // Not a directory or error
    }
}