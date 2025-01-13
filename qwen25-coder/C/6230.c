#include <gtk/gtk.h>\n\nstatic void modify_widget_colors(GtkWidget *widget, const gchar *background_color, const gchar *text_color) {\n    GtkCssProvider *provider;\n    GdkRGBA color;\n\n    provider = gtk_css_provider_new();\n    \n    // Set background and text color using CSS\n    if (background_color && gdk_rgba_parse(&color, background_color)) {\n        gtk_css_provider_load_from_data(provider,\n                                        ".widget {\n"\n                                        "   background-color: " BACKGROUND_COLOR ";\n"\n                                        "}\n",\n                                        -1, NULL);\n    }\n    \n    if (text_color && gdk_rgba_parse(&color, text_color)) {\n        gtk_css_provider_load_from_data(provider,\n                                        ".widget {\n"\n                                        "   color: " TEXT_COLOR ";\n"\n                                       "}\n",\n                                       -1, NULL);\n    }\n    \n    // Add the CSS provider to the widget\n    gtk_style_context_add_provider(gtk_widget_get_style_context(widget),\n                                   GTK_STYLE_PROVIDER(provider),\n                                   GTK_STYLE_PROVIDER_PRIORITY_USER);\n\n    g_object_unref(provider);\n}\n\nint main(int argc, char *argv[]) {\n    GtkWidget *window;\n    GtkWidget *hbox;\n    GtkWidget *vbox;\n    GtkWidget *label;\n\n    gtk_init(&argc, &argv);\n\n    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);\n    hbox = gtk_box_new(GTK_ORIENTATION_HORIZONTAL, 5);\n    vbox = gtk_box_new(GTK_ORIENTATION_VERTICAL, 5);\n    \n    // Adding widget to window\n    gtk_container_add(GTK_CONTAINER(window), hbox);\n    gtk_container_add(GTK_CONTAINER(hbox), vbox);\n\n    label = gtk_label_new("Sample Text");\n    gtk_container_add(GTK_CONTAINER(vbox), label);\n    \n    // Modify colors of the label and vbox\n    modify_widget_colors(label, "red", "white");\n    modify_widget_colors(vbox, "#3498db", "#ecf0f1");\n\n    g_signal_connect(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);\n\n    gtk_widget_show_all(window);\n    \n    gtk_main();\n\n    return 0;\n}