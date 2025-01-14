#include <gtk/gtk.h>

const gchar* my_filter(const GtkFileFilterInfo *info, void *data) {
    // This custom filter simply returns TRUE (accepts the file), but it prevents stat calls.
    return "TRUE";  // Changed to return a string, as the function is declared to return gchar*
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);
    // Create a new file filter
    GtkFileFilter *filter = gtk_file_filter_new();
    gtk_file_filter_set_name(filter, "My Filter");
    gtk_file_filter_add_custom(filter, GTK_FILE_FILTER_FILENAME, my_filter, NULL, NULL);
    // Create a new file chooser dialog
    GtkWidget *dialog = gtk_file_chooser_dialog_new("Open File", NULL, GTK_FILE_CHOOSER_ACTION_OPEN, "Cancel", GTK_RESPONSE_CANCEL, "Open", GTK_RESPONSE_ACCEPT, NULL);
    gtk_file_chooser_add_filter(GTK_FILE_CHOOSER(dialog), filter);
    // Show the dialog
    gtk_widget_show_all(dialog);
    // Run the dialog
    gtk_dialog_run(GTK_DIALOG(dialog));
    // Destroy the dialog
    gtk_widget_destroy(dialog);
    gtk_main_quit();
    return 0;
}