#include <gtk/gtk.h>

void on_aboutdialog_delete_event(GtkWidget *window, GdkEvent* event, gpointer user_data) {
    gtk_widget_hide_all(GTK_DIALOG(window));
    return TRUE; // Prevent the default action to destroy.
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);
    // Create the about dialog
    GtkWidget *about_dialog = gtk_about_dialog_new();
    // Connect the delete event to the on_aboutdialog_delete_event function
    g_signal_connect(about_dialog, "delete-event", G_CALLBACK(on_aboutdialog_delete_event), NULL);
    // Show the about dialog
    gtk_widget_show_all(about_dialog);
    gtk_main();
    return 0;
}