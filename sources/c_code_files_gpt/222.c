#include <gtk/gtk.h>

// Callback function for clipboard pasting
void on_paste_clipboard(GtkTextView *textview, gpointer user_data) {
    g_print("Text pasted into the TextView\n");
}

// Callback function for key press events
gboolean on_key_press_event(GtkWidget *widget, GdkEventKey *event, gpointer user_data) {
    g_print("Key pressed: %s\n", gdk_keyval_name(event->keyval));
    return FALSE; // Return FALSE to propagate the event further
}

int main(int argc, char *argv[]) {
    GtkWidget *window;
    GtkWidget *textview;
    GtkWidget *scrolled_window;

    gtk_init(&argc, &argv);

    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "TextView Example");
    gtk_window_set_default_size(GTK_WINDOW(window), 400, 200);

    scrolled_window = gtk_scrolled_window_new(NULL, NULL);
    gtk_container_add(GTK_CONTAINER(window), scrolled_window);

    textview = gtk_text_view_new();
    gtk_container_add(GTK_CONTAINER(scrolled_window), textview);

    // Connect signals
    g_signal_connect(textview, "paste-clipboard", G_CALLBACK(on_paste_clipboard), NULL);
    g_signal_connect(textview, "key-press-event", G_CALLBACK(on_key_press_event), NULL);

    g_signal_connect(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);

    gtk_widget_show_all(window);
    gtk_main();

    return 0;
}