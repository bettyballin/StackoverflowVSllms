#include <gtk/gtk.h>

void setup_tree_view(GtkTreeView *treeview) {
    GtkTreeViewColumn *column;
    GtkCellRenderer *renderer;

    // Create and set up the first column
    renderer = gtk_cell_renderer_text_new();
    column = gtk_tree_view_column_new_with_attributes("Column 1", renderer, "text", 0, NULL);
    gtk_tree_view_column_set_fixed_width(column, 100); // Set fixed width
    gtk_tree_view_append_column(treeview, column);

    // Create and set up the second column
    renderer = gtk_cell_renderer_text_new();
    column = gtk_tree_view_column_new_with_attributes("Column 2", renderer, "text", 1, NULL);
    gtk_tree_view_column_set_expand(column, TRUE); // This column will expand to fill remaining space
    gtk_tree_view_append_column(treeview, column);

    // Create and set up the third column
    renderer = gtk_cell_renderer_text_new();
    column = gtk_tree_view_column_new_with_attributes("Column 3", renderer, "text", 2, NULL);
    gtk_tree_view_column_set_fixed_width(column, 100); // Set fixed width
    gtk_tree_view_append_column(treeview, column);

    // Create and set up the fourth column
    renderer = gtk_cell_renderer_text_new();
    column = gtk_tree_view_column_new_with_attributes("Column 4", renderer, "text", 3, NULL);
    gtk_tree_view_column_set_fixed_width(column, 100); // Set fixed width
    gtk_tree_view_append_column(treeview, column);
}

int main(int argc, char *argv[]) {
    GtkWidget *window;
    GtkWidget *treeview;
    GtkListStore *store;

    gtk_init(&argc, &argv);

    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    treeview = gtk_tree_view_new();

    setup_tree_view(GTK_TREE_VIEW(treeview));

    store = gtk_list_store_new(4, G_TYPE_STRING, G_TYPE_STRING, G_TYPE_STRING, G_TYPE_STRING);
    gtk_tree_view_set_model(GTK_TREE_VIEW(treeview), GTK_TREE_MODEL(store));
    g_object_unref(store);

    gtk_container_add(GTK_CONTAINER(window), treeview);
    gtk_widget_show_all(window);

    g_signal_connect(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);
    gtk_main();

    return 0;
}