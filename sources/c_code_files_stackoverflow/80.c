#include <gtk/gtk.h>

int main(int argc, char *argv[]) {
    GtkWidget *menu_item, *accel_label;

    gtk_init(&argc, &argv);

    accel_label = gtk_accel_label_new("");
    gtk_label_set_markup(GTK_LABEL(accel_label), "<span color=\"red\">This text will be RED!</span>");
    menu_item = gtk_menu_item_new();
    gtk_container_add(GTK_CONTAINER(menu_item), accel_label);
    gtk_accel_label_set_accel_widget(GTK_ACCEL_LABEL(accel_label), menu_item);
    gtk_widget_show(accel_label);
    gtk_widget_show(menu_item);

    gtk_main();

    return 0;
}