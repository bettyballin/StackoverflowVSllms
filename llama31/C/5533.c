#include <gtk/gtk.h>\n\nint main() {\n    GtkWidget *window, *label;\n\n    gtk_init(NULL, NULL);\n\n    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);\n    gtk_window_set_title(GTK_WINDOW(window), "Hello World");\n\n    label = gtk_label_new("Hello World!");\n    gtk_container_add(GTK_CONTAINER(window), label);\n\n    gtk_widget_show_all(window);\n\n    gtk_main();\n\n    return 0;\n}