#include <gtk/gtk.h>

static void on_destroy(GtkWidget* widget, gpointer data)
{
        gtk_main_quit ();
}

int main (int argc, char* argv[])
{
        GtkWidget* window;
        GtkWidget* button;

        gtk_init(&argc, &argv);
        window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
        g_signal_connect(G_OBJECT (window), "destroy",
                G_CALLBACK (on_destroy), NULL);
        button = gtk_button_new_with_label("Hello world!");
        GdkColor red = {0, 0xffff, 0x0000, 0x0000};
        GdkColor green = {0, 0x0000, 0xffff, 0x0000};
        GdkColor blue = {0, 0x0000, 0x0000, 0xffff};
        gtk_widget_modify_bg(button, GTK_STATE_NORMAL, &red);
        gtk_widget_modify_bg(button, GTK_STATE_PRELIGHT, &green);
        gtk_widget_modify_bg(button, GTK_STATE_ACTIVE, &blue);
        gtk_container_add(GTK_CONTAINER(window), button);
        gtk_widget_show_all(window);
        gtk_main();
        return 0;
}