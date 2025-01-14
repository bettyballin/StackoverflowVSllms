#include <gtk/gtk.h>
#include <glib.h>
#include <pthread.h>

GAsyncQueue *doc_queue;     // Async queue for documents to save
gboolean saving = FALSE;    // Flag indicating if the thread is currently saving
GMainLoop *main_loop;       // Main loop for the application

void _savingCompleteFunction(void) {
    // Implement the saving complete function here
}

void autoSaveThread(void) {
  do {
    // Dequeue a document from doc_queue and start saving it asynchronously.
    // Use gdk_threads_add_* functions to marshal UI-related tasks back to main GTK thread when needed.
    void *doc = NULL;
    while ((doc = g_async_queue_pop(doc_queue))) {  // blocking queue pop until it's not empty
      if (!gdk_threads_acquire()) return;            // release the GUI thread to do other stuff, e.g., pen input processing

      // Perform saving here (asynchronously or on a separate I/O thread) in order to prevent blocking the main UI thread.

      gdk_threads_add_idle((GSourceFunc)_savingCompleteFunction, NULL);  // signal that autoSaveThread's task is complete
    }

    saving = FALSE;
  } while (!g_main_loop_is_running(main_loop) || !g_async_queue_is_empty(doc_queue));       // continuously perform autosave until user quit or queue is empty.
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);
    main_loop = g_main_loop_new(NULL, FALSE);
    doc_queue = g_async_queue_new();

    // Create a new thread for auto saving
    pthread_t thread;
    pthread_create(&thread, NULL, (void*)autoSaveThread, NULL);

    // Start the main loop
    g_main_loop_run(main_loop);

    // Clean up
    g_main_loop_unref(main_loop);
    g_async_queue_unref(doc_queue);

    return 0;
}