#include <gtk/gtk.h>
#include <gtkdatabox.h>

int main(int argc, char *argv[]) {
    // Initialize the GTK+ library
    gtk_init(&argc, &argv);

    // Create a new GtkDatabox widget
    GtkWidget *databox = gtk_databox_new();

    // You would typically show the widget and run the GTK+ main loop here,
    // but for simplicity, we'll just return immediately.
    return 0;
}