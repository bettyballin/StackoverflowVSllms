#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    // Initialize GTK
    gtk_init(&argc, &argv);

    // Create a window
    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "Sample Label");
    gtk_container_set_border_width(GTK_CONTAINER(window), 10);
    gtk_window_set_default_size(GTK_WINDOW(window), 200, 100);

    // Create a label and modify its text
    GtkWidget *my_label = gtk_label_new("sample text");
    gtk_label_set_text(GTK_LABEL(my_label), "new sample text");

    // Add the label to the window
    gtk_container_add(GTK_CONTAINER(window), my_label);

    // Show the window and all its contents
    gtk_widget_show_all(window);

    // Connect the "destroy" event to the signal handler
    g_signal_connect(G_OBJECT(window), "destroy", G_CALLBACK(gtk_main_quit), NULL);

    // Main loop
    gtk_main();

    return 0;
}