#include <gtk/gtk.h>

typedef struct {
    gint x;
    gint y;
} WindowPosition;

WindowPosition last_position = {0, 0};

void mycallback(GtkWindow* window, GdkEvent* event, gpointer data) {
    // Cast event to GdkEventConfigure to access the x, y, width, height properties
    GdkEventConfigure *configure_event = (GdkEventConfigure *)event;
    
    if (configure_event->x != last_position.x || configure_event->y != last_position.y) {
        // The window has been moved
        g_print("Window moved to (%d, %d)\n", configure_event->x, configure_event->y);

        // Update last known position
        last_position.x = configure_event->x;
        last_position.y = configure_event->y;
    } else {
        // The window has been resized
        g_print("Window resized to (%d, %d)\n", configure_event->width, configure_event->height);
    }
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);

    gtk_widget_add_events(GTK_WIDGET(window), GDK_CONFIGURE);
    g_signal_connect(G_OBJECT(window), "configure-event", G_CALLBACK(mycallback), NULL);

    gtk_widget_show_all(window);

    gtk_main();
    return 0;
}