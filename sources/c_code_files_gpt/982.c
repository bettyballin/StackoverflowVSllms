#include <string.h>
#include <stdio.h>

void load_buffer(char *buffer, size_t size);

int main()
{
    char buffer[100];
    printf("buffer size: %lu\n", sizeof(buffer)); // Use %lu for size_t
    load_buffer(buffer, sizeof(buffer));

    return 0;
}

void load_buffer(char *buffer, size_t size)
{
    printf("sizeof(buffer): %lu\n", size); // Use %lu for size_t
}