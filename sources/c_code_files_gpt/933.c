#include <gtk/gtk.h>
#include <glib.h>

gboolean show_next_image(gpointer data) {
    // Code to show the next image
    // ...

    return TRUE; // Continue calling this function
}

int main(int argc, char **argv) {
    // Initialize GTK before using it
    gtk_init(&argc, &argv);

    // Your existing initialization code
    // ...

    // Add a timeout to show the next image every 10 seconds
    g_timeout_add_seconds(10, show_next_image, NULL);

    gtk_main();

    return 0;
}