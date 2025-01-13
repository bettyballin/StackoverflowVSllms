#include <gtk/gtk.h>\n\nvoid modify_label(GtkLabel *label) {\n    gtk_label_set_text(label, "new text");\n}\n\nint main(int argc, char *argv[]) {\n    gtk_init(&argc, &argv);\n\n    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);\n    GtkWidget *label = gtk_label_new("original text");\n\n    gtk_container_add(GTK_CONTAINER(window), label);\n    gtk_widget_show_all(window);\n\n    // Pass the pointer to the modify_label function\n    modify_label(GTK_LABEL(label));\n\n    gtk_main();\n    return 0;\n}