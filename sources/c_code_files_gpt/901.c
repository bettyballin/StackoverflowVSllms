#include <gtk/gtk.h>

void on_size_allocate(GtkWidget *widget, GtkAllocation *allocation, gpointer user_data) {
    GtkScrolledWindow *scrolled_window = GTK_SCROLLED_WINDOW(user_data);
    // Scroll to the bottom
    gtk_adjustment_set_value(gtk_scrolled_window_get_vadjustment(scrolled_window), gtk_adjustment_get_upper(gtk_scrolled_window_get_vadjustment(scrolled_window)));
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *scrolled_window = gtk_scrolled_window_new(NULL, NULL);
    GtkWidget *widget = gtk_label_new("Test");

    gtk_container_add(GTK_CONTAINER(scrolled_window), widget);
    gtk_container_add(GTK_CONTAINER(window), scrolled_window);

    g_signal_connect(widget, "size-allocate", G_CALLBACK(on_size_allocate), scrolled_window);

    gtk_window_set_default_size(GTK_WINDOW(window), 400, 300);
    gtk_widget_show_all(window);

    gtk_main();

    return 0;
}