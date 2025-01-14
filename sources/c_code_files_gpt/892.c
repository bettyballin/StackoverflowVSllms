#include <stdio.h>
#include <unistd.h>
#include <gdk/gdk.h>

// Your GTK callback function
void my_gtk_callback(gpointer data, gint source, GdkInputCondition condition) {
    // Your callback implementation
}

int main() {
    int pipefd[2];

    // Create the anonymous pipe
    if (pipe(pipefd) == -1) {
        perror("pipe");
        return 1;
    }

    // Add the file descriptor to GDK input
    gdk_input_add(pipefd[0], GDK_INPUT_READ, my_gtk_callback, NULL);

    // Your main loop here

    // Clean up
    close(pipefd[0]);  // Close the read end of the pipe
    close(pipefd[1]);  // Close the write end of the pipe

    return 0;
}