#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    // Initialize GTK+ 
    gtk_init(&argc, &argv);

    // Create a window to hold the menu
    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "GTK+ Menu Example");
    gtk_window_set_default_size(GTK_WINDOW(window), 200, 100);

    // Create a menu item
    GtkWidget *gtm_item = gtk_menu_item_new();
    const gchar *text_to_set = "New Text";
    gtk_menu_item_set_label(GTK_MENU_ITEM(gtm_item), text_to_set);

    // Create a menu and add the menu item to it
    GtkWidget *menu = gtk_menu_new();
    gtk_menu_shell_append(GTK_MENU_SHELL(menu), gtm_item);

    // Create a menu bar and add the menu to it
    GtkWidget *menu_bar = gtk_menu_bar_new();
    gtk_menu_bar_append(GTK_MENU_BAR(menu_bar), gtk_menu_item_new_with_label("File"));

    // Add the menu bar to the window
    gtk_container_add(GTK_CONTAINER(window), menu_bar);

    // Show all widgets
    gtk_widget_show_all(window);

    // Connect the "destroy" signal of the window to gtk_main_quit
    g_signal_connect(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);

    // Run the GTK+ main loop
    gtk_main();

    return 0;
}