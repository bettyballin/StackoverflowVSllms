#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);
    
    // Create a window and a tree view
    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *tree_view = gtk_tree_view_new();
    
    // Add the tree view to the window
    gtk_container_add(GTK_CONTAINER(window), tree_view);
    
    // Show all widgets
    gtk_widget_show_all(window);
    
    // Get the first column of the tree view (if it exists)
    GtkTreeViewColumn *column = gtk_tree_view_get_column(GTK_TREE_VIEW(tree_view), 0);
    
    // Check if the column was retrieved successfully
    if (column != NULL) {
        g_print("Got the first column.\n");
    } else {
        g_print("Failed to get the first column.\n");
    }
    
    // Run the GTK+ main loop
    gtk_main();
    
    return 0;
}