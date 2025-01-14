#include <gtk/gtk.h>

static gboolean on_draw(GtkWidget *widget, cairo_t *cr, gpointer data) {
    GdkRGBA color = {1.0, 0.0, 0.0, 0.5}; // Red color with 50% opacity
    gdk_cairo_set_source_rgba(cr, &color);
    cairo_paint(cr);
    return FALSE;
}

static void on_button_clicked(GtkButton *button, gpointer data) {
    GtkWidget *window = GTK_WIDGET(data);
    gtk_widget_show_all(window);
}

int main(int argc, char *argv[]) {
    gtk_init(&argc, &argv);

    // Create a full-screen window
    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_decorated(GTK_WINDOW(window), FALSE);
    gtk_window_fullscreen(GTK_WINDOW(window));
    gtk_widget_set_app_paintable(window, TRUE);

    // Connect the draw event
    g_signal_connect(G_OBJECT(window), "draw", G_CALLBACK(on_draw), NULL);

    // Create a button to trigger the screen flash
    GtkWidget *button = gtk_button_new_with_label("Flash Screen");
    g_signal_connect(G_OBJECT(button), "clicked", G_CALLBACK(on_button_clicked), window);

    // Create a container for the button
    GtkWidget *box = gtk_box_new(GTK_ORIENTATION_VERTICAL, 0);
    gtk_box_pack_start(GTK_BOX(box), button, TRUE, TRUE, 0);

    // Create a main application window
    GtkWidget *main_window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    g_signal_connect(main_window, "destroy", G_CALLBACK(gtk_main_quit), NULL);
    gtk_container_add(GTK_CONTAINER(main_window), box);

    gtk_widget_show_all(main_window);
    
    gtk_main();

    return 0;
}