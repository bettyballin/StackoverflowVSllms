#include <gtk/gtk.h>

void your_callback(GtkClipboard *clipboard, gpointer data) {
    // your callback function for paste-clipboard signal
}

void your_insert_callback(GtkTextBuffer *buffer, gchar *text, gint length, gpointer data) {
    // your callback function for insert-at-cursor signal
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *textview = gtk_text_view_new();

    GtkClipboard *clipboard = gtk_clipboard_get(GDK_SELECTION_CLIPBOARD);
    g_signal_connect(clipboard, "owner-change", G_CALLBACK(your_callback), NULL);

    GtkTextBuffer *buffer = gtk_text_view_get_buffer(GTK_TEXT_VIEW(textview));
    g_signal_connect(buffer, "insert-text", G_CALLBACK(your_insert_callback), NULL);

    gtk_container_add(GTK_CONTAINER(window), textview);
    gtk_widget_show_all(window);

    gtk_main();
    return 0;
}