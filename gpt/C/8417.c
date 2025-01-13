#include <gtk/gtk.h>\n#include <gdk/gdkx.h>\n\nvoid get_window_id(GtkWidget *widget) {\n    GdkWindow *gdk_window = gtk_widget_get_window(widget);\n    if (gdk_window != NULL) {\n        Window xid = GDK_WINDOW_XID(gdk_window);\n        g_print("Window ID: %lu\n", (unsigned long)xid);\n    } else {\n        g_print("Widget does not have a GdkWindow\n");\n    }\n}\n\nint main(int argc, char *argv[]) {\n    gtk_init(&argc, &argv);\n\n    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);\n    GtkWidget *button = gtk_button_new_with_label("Get Window ID");\n\n    g_signal_connect(button, "clicked", G_CALLBACK(get_window_id), NULL);\n\n    gtk_container_add(GTK_CONTAINER(window), button);\n    gtk_widget_show_all(window);\n\n    gtk_main();\n    return 0;\n}