#include <gtk/gtk.h>

// Define the callback function for the button click
void button_clicked(GtkWidget *sender, gpointer data) {
    // button pressed
}

// Define the callback function for the key press event
gboolean key_press_event(GtkWidget *sender, GdkEventKey *ev, gpointer data) {
    if (ev->keyval == GDK_Tab) {
        return TRUE; // we handle Tab ourselves and prevent default behavior
    } else {
        return FALSE; // we didn't handle it, so GTK+ does default behavior
    }
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *button = gtk_button_new_with_label("Click me");

    // Connect the callback functions
    g_signal_connect(button, "clicked", G_CALLBACK(button_clicked), NULL);
    g_signal_connect(window, "key-press-event", G_CALLBACK(key_press_event), NULL);

    // Add the button to the window
    gtk_container_add(GTK_CONTAINER(window), button);

    // Show the window and its contents
    gtk_widget_show_all(window);

    // Run the GTK+ main loop
    gtk_main();

    return 0;
}