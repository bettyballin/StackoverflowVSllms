#include <glib.h>
#include <stdbool.h>

GAsyncQueue *doc_queue;
gboolean saving = FALSE;

void enqueueDocForSaving(void *doc) {
    if (!saving) {
        g_async_queue_push(doc_queue, doc);         // Add the document for autosave. This will unblock autoSaveThread's blocking queue popping (`while ((doc = g_async_queue_pop(doc_queue)))`) and activate saving procedure.
        saving = TRUE;                              // Indicate that a save is in progress to prevent repeated enqueuing while the same doc is being saved.
    } else {
        // Reasonable behavior based on your application's functionality, e.g., wait until previous saves are completed or discard this document from saving by not adding it to queue.
    }
}

int main() {
    // Initialize the queue
    doc_queue = g_async_queue_new();

    // Your code here...

    return 0;
}