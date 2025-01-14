#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    // Initialize GTK+ before proceeding
    gtk_init(&argc, &argv);

    // Assuming 'widget' is a GTK widget that has been created or retrieved
    GtkWidget *widget = gtk_window_new(GTK_WINDOW_TOPLEVEL);

    GtkCssProvider *provider = gtk_css_provider_new();
    gtk_css_provider_load_from_path(provider, "styles.css", NULL);

    GtkStyleContext *context = gtk_widget_get_style_context(widget);
    gtk_style_context_add_provider(context, GTK_STYLE_PROVIDER(provider), GTK_STYLE_PROVIDER_PRIORITY_USER);

    // Run the GTK main loop
    gtk_main();

    return 0;
}