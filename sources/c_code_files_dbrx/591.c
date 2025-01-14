#include <gtk/gtk.h>

void on_aboutdialog_close(GtkButton *button, gpointer user_data) {
    GtkWidget *widget = GTK_WIDGET(user_data);
    gtk_widget_hide_all(GTK_DIALOG(widget));
}

int main(int argc, char *argv[]) {
    GtkWidget *window;
    GtkWidget *aboutdialog;
    GtkWidget *closebutton;

    gtk_init(&argc, &argv);

    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "GTK+ Example");
    gtk_window_set_default_size(GTK_WINDOW(window), 250, 150);

    aboutdialog = gtk_about_dialog_new();
    gtk_about_dialog_set_version(GTK_ABOUT_DIALOG(aboutdialog), "1.0");
    gtk_about_dialog_set_name(GTK_ABOUT_DIALOG(aboutdialog), "GTK+ Example");
    gtk_about_dialog_set_comments(GTK_ABOUT_DIALOG(aboutdialog), "This is an example GTK+ application.");

    closebutton = gtk_button_new_with_label("Show About Dialog");
    gtk_container_add(GTK_CONTAINER(window), closebutton);

    g_signal_connect(closebutton, "clicked", G_CALLBACK(gtk_widget_show_all), aboutdialog);
    g_signal_connect_swapped(closebutton, "clicked", G_CALLBACK(gtk_widget_hide), closebutton);

    GtkWidget *aboutCloseButton = gtk_dialog_get_widget_for_response(GTK_DIALOG(aboutdialog), GTK_RESPONSE_CLOSE);
    g_signal_connect(aboutCloseButton, "clicked", G_CALLBACK(on_aboutdialog_close), aboutdialog);

    g_signal_connect_swapped(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);

    gtk_widget_show_all(window);

    gtk_main();

    return 0;
}