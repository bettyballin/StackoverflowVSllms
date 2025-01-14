#include <gtk/gtk.h>

// Define a custom filter function
static gboolean my_filter(const GtkFileFilterInfo *filter_info, gpointer data) {
    // This is a very basic example filter that accepts files with a .txt extension
    if (filter_info->mime_type && g_str_has_suffix(filter_info->mime_type, "text/plain")) {
        return TRUE;
    }
    return FALSE;
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    // Create a new file filter
    GtkFileFilter *my_filter_info = gtk_file_filter_new();

    // Add a custom filter that accepts files based on the my_filter function
    gtk_file_filter_add_custom(GTK_FILE_FILTER(my_filter_info), GTK_FILE_FILTER_MIME_TYPE, (GtkFileFilterFlags)0, my_filter, NULL);

    // Example usage: Create a file chooser dialog and apply the filter
    GtkWidget *dialog = gtk_file_chooser_dialog_new("Open File", NULL, GTK_FILE_CHOOSER_ACTION_OPEN, "Cancel", GTK_RESPONSE_CANCEL, "Open", GTK_RESPONSE_ACCEPT, NULL);
    gtk_file_chooser_set_filter(GTK_FILE_CHOOSER(dialog), my_filter_info);

    if (gtk_dialog_run(GTK_DIALOG(dialog)) == GTK_RESPONSE_ACCEPT) {
        gchar *filename;
        filename = gtk_file_chooser_get_filename(GTK_FILE_CHOOSER(dialog));
        g_print("File selected: %s\n", filename);
        g_free(filename);
    }

    gtk_widget_destroy(dialog);
    g_object_unref(my_filter_info);

    gtk_main_quit();
    return 0;
}