#include <gtk/gtk.h>

void show_sort_indicator(GtkWidget *tree_column, GtkWidget *arrow, gint sort_column_id, GtkTreeModel *model) {
    if (gtk_tree_view_column_get_sort_indicator(tree_column) ||
       (GTK_IS_TREE_SORTABLE (model) && sort_column_id >= 0))
        gtk_widget_show (arrow);
    else
        gtk_widget_hide (arrow);
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    // Create a window
    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "Tree View Sort Indicator");
    gtk_container_set_border_width(GTK_CONTAINER(window), 10);
    gtk_window_set_default_size(GTK_WINDOW(window), 400, 300);

    // Create a tree view
    GtkWidget *tree_view = gtk_tree_view_new();
    gtk_container_add(GTK_CONTAINER(window), tree_view);

    // Create a tree model
    GtkListStore *store = gtk_list_store_new(1, G_TYPE_STRING);
    gtk_tree_view_set_model(GTK_TREE_VIEW(tree_view), GTK_TREE_MODEL(store));

    // Create a tree view column
    GtkTreeViewColumn *tree_column = gtk_tree_view_column_new_with_attributes("Column", gtk_cell_renderer_text_new(), "text", 0, NULL);
    gtk_tree_view_append_column(GTK_TREE_VIEW(tree_view), tree_column);

    // Create an arrow widget
    GtkWidget *arrow = gtk_arrow_new(GTK_ARROW_DOWN, GTK_SHADOW_IN);

    // Call the function to show or hide the arrow
    show_sort_indicator(GTK_WIDGET(tree_column), arrow, 0, GTK_TREE_MODEL(store));

    // Show the window and its contents
    gtk_widget_show_all(window);

    gtk_main();

    return 0;
}