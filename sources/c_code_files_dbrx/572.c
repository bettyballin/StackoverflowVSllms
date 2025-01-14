#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    // Initialize GTK+
    gtk_init(&argc, &argv);

    // Create a window and a tree view
    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *tree_view = gtk_tree_view_new();

    // Create columns
    GtkTreeViewColumn *column1 = gtk_tree_view_column_new();
    GtkTreeViewColumn *column2 = gtk_tree_view_column_new();
    GtkTreeViewColumn *column3 = gtk_tree_view_column_new();

    // Set column sizing
    gtk_tree_view_column_set_sizing(column3, GTK_TREE_VIEW_COLUMN_FIXED);
    gtk_tree_view_column_set_fixed_width(column1, 80);

    // Add columns to the tree view
    gtk_tree_view_append_column(GTK_TREE_VIEW(tree_view), column1);
    gtk_tree_view_append_column(GTK_TREE_VIEW(tree_view), column2);
    gtk_tree_view_append_column(GTK_TREE_VIEW(tree_view), column3);

    // Add the tree view to the window
    gtk_container_add(GTK_CONTAINER(window), tree_view);

    // Show the window and its contents
    gtk_widget_show_all(window);

    // Run the GTK+ main loop
    gtk_main();

    return 0;
}