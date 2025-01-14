#include <io.h>
#include <stdio.h>

int main() {
    const char *filePath = "path_to_your_file.txt";  // replace with your file path
    if(_access(filePath, 0) != -1) {
       printf("The file exists. Perform your operation.\n");
    } else {
       printf("File doesn't exist\n");
    }
    return 0;
}