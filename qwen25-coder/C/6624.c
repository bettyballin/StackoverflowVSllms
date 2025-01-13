#include <gtk/gtk.h>\n\nint main(int argc, char *argv[]) {\n    GtkWidget* window;\n    GtkWidget* content;\n    GtkWidget* sw;\n\n    gtk_init(&argc, &argv);\n    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);\n\n    g_signal_connect(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);\n\n    // Create scrolled window and set its expand to true\n    sw = gtk_scrolled_window_new(NULL, NULL);\n    gtk_widget_set_hexpand(sw, TRUE);  // Expand horizontally\n    gtk_widget_set_vexpand(sw, TRUE);  // Expand vertically\n    gtk_container_add(GTK_CONTAINER(window), sw);\n    \n    // Set scrolling policies\n    gtk_scrolled_window_set_policy(GTK_SCROLLED_WINDOW(sw),\n                                   GTK_POLICY_NEVER, GTK_POLICY_NEVER);\n\n    content = gtk_button_new_with_label("This is a very, very"\n                                        "very very very very very very very long text");\n    gtk_container_add(GTK_CONTAINER(sw), content);  // Directly add to scrolled window\n\n    gtk_widget_show_all(window);\n    \n    gtk_main();\n\n    return 0;\n}