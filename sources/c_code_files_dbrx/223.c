#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *menu_item = gtk_menu_item_new();
    GtkWidget *label = gtk_label_new("SomeText");

    GdkColor red_color;
    gdk_color_parse("#FF0000", &red_color); // Define the red color
    gtk_widget_modify_fg(GTK_WIDGET(label), GTK_STATE_NORMAL, &red_color);

    gtk_container_add(GTK_CONTAINER(menu_item), label);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_container_add(GTK_CONTAINER(window), menu_item);
    gtk_window_set_default_size(GTK_WINDOW(window), 200, 100);
    gtk_widget_show_all(window);

    gtk_main();
    return 0;
}