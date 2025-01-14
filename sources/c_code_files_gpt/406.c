#include <gtk/gtk.h>

void remove_sort_arrow(GtkTreeViewColumn *column) {
    // Disable the sort indicator
    gtk_tree_view_column_set_sort_indicator(column, FALSE);

    // Ensure the column is resizable
    gtk_tree_view_column_set_resizable(column, TRUE);
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *treeview = gtk_tree_view_new();
    gtk_container_add(GTK_CONTAINER(window), treeview);

    GtkTreeViewColumn *column = gtk_tree_view_column_new_with_attributes("Title", gtk_cell_renderer_text_new(), "text", 0, NULL);
    gtk_tree_view_append_column(GTK_TREE_VIEW(treeview), column);

    // Remove the sort arrow and adjust the column
    remove_sort_arrow(column);

    gtk_widget_show_all(window);
    gtk_main();

    return 0;
}