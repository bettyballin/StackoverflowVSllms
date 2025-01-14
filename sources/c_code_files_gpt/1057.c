#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    GtkWidget *widget;

    gtk_init(&argc, &argv);

    widget = gtk_button_new_with_label("Hello, World!");
    gtk_widget_show_now(widget);

    gtk_main();

    return 0;
}