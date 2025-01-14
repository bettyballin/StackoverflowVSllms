#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_default_size(GTK_WINDOW(window), 400, 300);
    g_signal_connect(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);

    GtkWidget *stack = gtk_stack_new();
    gtk_container_add(GTK_CONTAINER(window), stack);

    // First widget (e.g., a label)
    GtkWidget *label = gtk_label_new("Label widget");
    gtk_stack_add_named(GTK_STACK(stack), label, "label");

    // Second widget (e.g., a button)
    GtkWidget *button = gtk_button_new_with_label("Button widget");
    gtk_stack_add_named(GTK_STACK(stack), button, "button");

    // Set properties to control visibility and transition
    gtk_stack_set_visible_child(GTK_STACK(stack), label);
    gtk_stack_set_transition_type(GTK_STACK(stack), GTK_STACK_TRANSITION_TYPE_SLIDE_LEFT_RIGHT);

    gtk_widget_show_all(window);
    gtk_main();

    return 0;
}