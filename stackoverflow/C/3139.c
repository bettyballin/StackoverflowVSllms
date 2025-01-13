#include <gtk/gtk.h>\n\nstatic void on_destroy(GtkWidget* widget, gpointer data)\n{\n        gtk_main_quit ();\n}\n\nint main (int argc, char* argv[])\n{\n        GtkWidget* window;\n        GtkWidget* button;\n\n        gtk_init(&argc, &argv);\n        window = gtk_window_new(GTK_WINDOW_TOPLEVEL);\n        g_signal_connect(G_OBJECT (window), "destroy",\n                G_CALLBACK (on_destroy), NULL);\n        button = gtk_button_new_with_label("Hello world!");\n        GdkColor red = {0, 0xffff, 0x0000, 0x0000};\n        GdkColor green = {0, 0x0000, 0xffff, 0x0000};\n        GdkColor blue = {0, 0x0000, 0x0000, 0xffff};\n        gtk_widget_modify_bg(button, GTK_STATE_NORMAL, &red);\n        gtk_widget_modify_bg(button, GTK_STATE_PRELIGHT, &green);\n        gtk_widget_modify_bg(button, GTK_STATE_ACTIVE, &blue);\n        gtk_container_add(GTK_CONTAINER(window), button);\n        gtk_widget_show_all(window);\n        gtk_main();\n        return 0;\n}