#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    GtkWidget* window;
    GtkWidget* content;
    GtkWidget* sw;

    gtk_init(&argc, &argv);
    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);

    sw = gtk_scrolled_window_new(NULL, NULL);
    gtk_scrolled_window_set_policy(GTK_SCROLLED_WINDOW(sw), GTK_POLICY_NEVER, GTK_POLICY_NEVER);
    gtk_container_add(GTK_CONTAINER(window), sw);
    gtk_widget_show(sw);

    content = gtk_button_new_with_label("This is a very, very"
            "very very very very very very very very long text");
    gtk_scrolled_window_add_with_viewport(GTK_SCROLLED_WINDOW(sw), content);
    gtk_widget_show(content);

    gtk_widget_show(window);
    gtk_main();

    return 0;
}