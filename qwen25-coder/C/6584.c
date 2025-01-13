#include <gtk/gtk.h>\n\nint main(int argc, char *argv[]) {\n    GtkWidget *window;\n    GdkScreen *screen;\n    int width_mm, height_mm;\n    double x_dpi, y_dpi;\n\n    gtk_init(&argc, &argv);\n\n    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);\n    screen = gtk_widget_get_screen(window);\n\n    if (screen) {\n        width_mm = gdk_screen_get_width_mm(screen);\n        height_mm = gdk_screen_get_height_mm(screen);\n        x_dpi = gdk_screen_get_width(screen) / (width_mm / 25.4);\n        y_dpi = gdk_screen_get_height(screen) / (height_mm / 25.4);\n\n        printf("X DPI: %.2f\n", x_dpi);\n        printf("Y DPI: %.2f\n", y_dpi);\n    } else {\n        g_printerr("Unable to get screen!\n");\n        return -1;\n    }\n\n    gtk_widget_destroy(window);\n    return 0;\n}