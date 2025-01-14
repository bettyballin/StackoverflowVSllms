#include <stdio.h>

int main() {
    FILE* handle = fopen("yourfile.txt", "rb"); // Open your existing txt file by 'read binary' mode
    if (!handle) { 
        printf("Cannot open the file!\n"); 
        return 1; 
    }
    // Assume we want to read 5 characters that starting from offset '10'. Then, allocate a buffer with size of '6' (include null-terminate character \0).
    char buf[6] = ""; // Buffer must exist within your program life time if you want to access it later by its pointer. If not reuse this buf for next operation or release the memory after handling it to prevent potential memory leak.
    fseek(handle, 10L, SEEK_SET); // Navigate cursor to offset '10' from beginning of file (SEEK_SET).
    if ( fread(buf, sizeof(char), 5, handle) == 5 ) { 
        printf("%s\n", buf); 
    } else { 
        printf("Cannot read those 5 characters at offset %d!\n", 10); 
    }; // Read '5' size of char from the file and store into our buffer.
    // Remember to handle/release your resource, e.g., close opened files when you finish using them or free any allocated memory in C language.
    fclose(handle);
    return 0;
}