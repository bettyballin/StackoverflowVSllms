#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

void *writer_thread(void *args) {
    char buffer[256];
    while (fgets(buffer, sizeof buffer, stdin)) {  // Read from stdout and write it to our dedicated thread's stdout
        printf("Writer thread: %s", buffer);
    }
    return NULL; // pthread requires threads to return void*
}

int main() {
    setvbuf(stdout, NULL, _IONBF, 0);   // Make stdout unbuffered. The printfs will now directly write to the output stream rather than buffering in memory until it's full or fflush is called.
    printf("Example text from main\n");

    pthread_t thread;
    pthread_create(&thread, NULL, writer_thread, NULL);
    pthread_join(thread, NULL); // wait for the thread to finish

    return 0;
}