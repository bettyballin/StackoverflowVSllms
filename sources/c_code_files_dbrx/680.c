#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GdkColor red_color;
    gdk_color_parse("red", &red_color);

    // You can now use the red_color variable
    // For example, to set the text color of a label:
    GtkWidget *label = gtk_label_new("Hello, World!");
    gtk_widget_modify_fg(GTK_WIDGET(label), GTK_STATE_NORMAL, &red_color);

    // Don't forget to show the label and run the main loop
    gtk_widget_show(label);
    gtk_main();

    return 0;
}