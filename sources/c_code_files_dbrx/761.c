#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    // Initialize GTK
    gtk_init(&argc, &argv);

    // Create a GtkBox with horizontal orientation and margin of zero
    GtkWidget *box = gtk_box_new(GTK_ORIENTATION_HORIZONTAL, 0);

    // Create widgetA and widgetB
    GtkWidget *widgetA = gtk_label_new("Widget A");
    GtkWidget *widgetB = gtk_label_new("Widget B");

    // Create an overlay
    GtkWidget *overlay = gtk_overlay_new();

    // Add main child i.e., widgetA to the box so that it will stretch to fill horizontally and vertically in its allocated space
    gtk_box_pack_start(GTK_BOX(box), widgetA, TRUE, TRUE, 0);

    // Note: gtk_widget_set_child_pack is not a valid GTK function. 
    // Instead, we use gtk_box_pack_start to add the widget to the box.

    // Set parent of the second widget as overlay itself
    gtk_overlay_add_overlay(GTK_OVERLAY(overlay), widgetB);

    // Note: gtk_widget_set_parent is not the correct function to add a widget to an overlay.
    // Instead, we use gtk_overlay_add_overlay to add the widget to the overlay.

    // Create a window and add the box to it
    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_container_add(GTK_CONTAINER(window), box);

    // Show all widgets
    gtk_widget_show_all(window);

    // Run the GTK main loop
    gtk_main();

    return 0;
}