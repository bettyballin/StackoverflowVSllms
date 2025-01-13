#include <gtk/gtk.h>\n\nint main(int argc, char *argv[]) {\n    gtk_init(&argc, &argv);\n\n    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);\n    gtk_window_set_title(GTK_WINDOW(window), "Colored Button");\n    gtk_window_set_default_size(GTK_WINDOW(window), 300, 200);\n\n    GtkWidget *button = gtk_button_new_with_label("Click me!");\n    gtk_container_add(GTK_CONTAINER(window), button);\n\n    GtkCssProvider *provider = gtk_css_provider_new();\n    gtk_css_provider_load_from_data(provider, "button { background-color: #FF0000; color: #FFFFFF; }", -1, NULL);\n    gtk_style_context_add_provider_for_screen(gdk_screen_get_default(), GTK_STYLE_PROVIDER(provider), GTK_STYLE_PROVIDER_PRIORITY_APPLICATION);\n\n    gtk_widget_show_all(window);\n\n    gtk_main();\n\n    return 0;\n}