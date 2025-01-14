#include <gtk/gtk.h>

int main() {
    gtk_init(NULL, NULL);

    while (gtk_events_pending()) {
        gtk_main_iteration();
    }

    gtk_main_quit();
    return 0;
}