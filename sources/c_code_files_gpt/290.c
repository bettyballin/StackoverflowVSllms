#include <gtk/gtk.h>

void modify_label(GtkLabel *label) {
    gtk_label_set_text(label, "new text");
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    GtkWidget *label = gtk_label_new("original text");

    gtk_container_add(GTK_CONTAINER(window), label);
    gtk_widget_show_all(window);

    // Pass the pointer to the modify_label function
    modify_label(GTK_LABEL(label));

    gtk_main();
    return 0;
}