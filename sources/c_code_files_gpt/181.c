#include <gtk/gtk.h>

static void on_activate (GtkApplication *app) {
    // Create a new application window
    GtkWidget *window = gtk_application_window_new(app);
    // Set the title of the window
    gtk_window_set_title(GTK_WINDOW(window), "Hello, World!");
    // Set the default size of the window
    gtk_window_set_default_size(GTK_WINDOW(window), 200, 200);
    // Show all widgets
    gtk_widget_show_all(window);
}

int main (int argc, char **argv) {
    // Create a new application
    GtkApplication *app = gtk_application_new("com.example.GtkApp", G_APPLICATION_FLAGS_NONE);
    // Connect the "activate" signal to the on_activate function
    g_signal_connect(app, "activate", G_CALLBACK(on_activate), NULL);
    // Run the application
    int status = g_application_run(G_APPLICATION(app), argc, argv);
    // Unreference the application
    g_object_unref(app);
    return status;
}