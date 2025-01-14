#include <gtk/gtk.h>

void change_menu_item_text(GtkMenuItem *menu_item, const gchar *new_text) {
    GtkWidget *label = gtk_bin_get_child(GTK_BIN(menu_item));
    if (GTK_IS_LABEL(label)) {
        gtk_label_set_text(GTK_LABEL(label), new_text);
    }
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *menu_bar = gtk_menu_bar_new();
    GtkWidget *menu = gtk_menu_new();
    GtkWidget *menu_item = gtk_menu_item_new_with_label("Original Text");

    gtk_menu_shell_append(GTK_MENU_SHELL(menu), menu_item);
    gtk_menu_item_set_submenu(GTK_MENU_ITEM(menu_item), menu);
    gtk_menu_shell_append(GTK_MENU_SHELL(menu_bar), menu_item);
    gtk_container_add(GTK_CONTAINER(window), menu_bar);

    gtk_widget_show_all(window);

    // Change the text of the menu item after 2 seconds
    g_timeout_add_seconds(2, (GSourceFunc)change_menu_item_text, "New Text");
    g_timeout_add_seconds(4, (GSourceFunc)gtk_main_quit, NULL);

    gtk_main();

    g_object_unref(menu_item);
    return 0;
}