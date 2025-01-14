#include <gtk/gtk.h>

void print_widget_size(GtkWidget *widget) {
    // Ensure the widget is realized and mapped
    if (gtk_widget_get_realized(widget) && gtk_widget_get_mapped(widget)) {
        gint width = gtk_widget_get_allocated_width(widget);
        gint height = gtk_widget_get_allocated_height(widget);
        g_print("Widget size: width=%d, height=%d\n", width, height);
    } else {
        g_print("Widget is not realized or mapped.\n");
    }
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *button = gtk_button_new_with_label("Click Me");

    gtk_container_add(GTK_CONTAINER(window), button);

    g_signal_connect(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);
    g_signal_connect(button, "clicked", G_CALLBACK(print_widget_size), button); // Pass the button as an argument

    gtk_widget_show_all(window);

    gtk_main();

    return 0;
}