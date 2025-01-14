#include <pthread.h>
#include <gtk/gtk.h>
#include <glib.h>

// Define the autoSaveThread function
void* autoSaveThread(void* arg) {
    // Add your auto-save logic here
    return NULL;
}

int main() {
    // Initialize GTK
    gtk_init(NULL, NULL);

    // Initialize threading support in GTK
    gdk_threads_init();

    // Create a new GAsyncQueue for documents to save
    GAsyncQueue* queue = g_async_queue_new();

    // Create a thread identifier
    pthread_t t1;

    // Spawn the auto-save thread
    pthread_create(&t1, NULL, autoSaveThread, NULL);

    // Run the GTK main loop
    gtk_main();

    // Clean up
    g_async_queue_unref(queue);

    return 0;
}