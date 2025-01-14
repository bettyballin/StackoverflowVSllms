#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    GtkWidget *overlay;
    GtkWidget *widgetA;
    GtkWidget *widgetB;

    // Initialize GTK+ before proceeding
    gtk_init(&argc, &argv);

    // Create the main window
    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "GtkOverlay Example");
    gtk_window_set_default_size(GTK_WINDOW(window), 300, 200);

    // Create a GtkOverlay
    overlay = gtk_overlay_new();

    // Create widgetA (for example, a label)
    widgetA = gtk_label_new("This is widget A");

    // Create widgetB (for example, a button)
    widgetB = gtk_button_new_with_label("Widget B");

    // Add main child i.e., widgetA to the overlay
    gtk_container_add(GTK_CONTAINER(overlay), widgetA);

    // Set parent of the second widget as overlay itself
    gtk_widget_set_parent(widgetB, overlay);

    // Add the overlay to the window
    gtk_container_add(GTK_CONTAINER(window), overlay);

    // Show all widgets inside the window
    gtk_widget_show_all(window);

    // Connect to the "destroy" signal of the window to exit GTK+ when it is destroyed
    g_signal_connect(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);

    // Run the GTK+ main loop
    gtk_main();

    return 0;
}