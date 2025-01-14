#include <gtk/gtk.h>
#include <gdk/gdkx.h>

void get_window_id(GtkWidget *widget, gpointer data) {
    GdkWindow *gdk_window = gtk_widget_get_window(widget);
    if (gdk_window != NULL) {
        Window xid = GDK_WINDOW_XID(gdk_window);
        g_print("Window ID: %lu\n", (unsigned long)xid);
    } else {
        g_print("Widget does not have a GdkWindow\n");
    }
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *button = gtk_button_new_with_label("Get Window ID");

    g_signal_connect(button, "clicked", G_CALLBACK(get_window_id), NULL);

    gtk_container_add(GTK_CONTAINER(window), button);
    gtk_widget_show_all(window);
    gtk_window_set_default_size(GTK_WINDOW(window), 200, 50);

    gtk_main();
    return 0;
}