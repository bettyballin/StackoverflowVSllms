#include <gtk/gtk.h>\n\nvoid on_close_button_clicked(GtkWidget *button, gpointer user_data) {\n    GtkWidget *dialog = gtk_widget_get_parent(GTK_WIDGET(button));\n    gtk_widget_hide(dialog);\n}