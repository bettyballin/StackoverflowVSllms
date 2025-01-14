#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

void *writer_thread(void *args) {
    char buffer[256];
    FILE *fp = popen("cat", "w");  // Open a pipe where the output goes to cat command as input. This is our stdout buffer.
    while (1) {
        size_t bytes_read;
        bytes_read = fread(buffer, sizeof(char), sizeof(buffer)-1, fp);  // Read from pipes/file descriptor associated with the "cat" command

        if (!bytes_read) break;

        buffer[bytes_read]='\0';   // null terminate the string so we can print it.
        printf("Writer thread: %s",buffer);  // Write to stdout in a dedicated thread, this will not block your worker threads.
    }
    pclose(fp);
}

int main() {
    // Start writer thread before writing anything to stdout
    pthread_t writerThreadId;
    pthread_create(&writerThreadId, NULL, &writer_thread, NULL);

    printf("Example text from main\n");  // This will be written to our memory buffer and then to stdout by the dedicated thread.

    // Rest of your code that writes to stdout...

    pthread_join(writerThreadId, NULL); // Wait for the writer thread to finish

    return 0;
}