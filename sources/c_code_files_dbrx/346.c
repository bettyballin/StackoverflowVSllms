#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    GtkWidget* window;
    GtkWidget* content;
    GtkWidget* sw;

    gtk_init(&argc, &argv);

    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    sw = gtk_scrolled_window_new(NULL, NULL);
    gtk_widget_set_size_request(sw, -1, -1);

    content = gtk_button_new_with_label("This is a very, very very long text");

    gtk_container_add(GTK_CONTAINER(window), sw);
    gtk_container_add(GTK_CONTAINER(sw), content);

    gtk_widget_show_all(window);

    gtk_main();

    return 0;
}