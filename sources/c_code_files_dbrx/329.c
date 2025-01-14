#include <gtk/gtk.h>

void quit_cb(GtkWidget *widget, gpointer data) {
    gtk_main_quit();
}

int main ( int argc, char **argv ) {
    GtkWidget *window;
    GtkWidget *menu, *exit;
    GtkAccelGroup *accel_group;
    char *str="<Ctrl>Q"; // shortcut Ctrl+Q for the "Quit" menu item
    gint accel_key = 0; // The numerical representation of character in accelerator string (in this case 'q'=16)

    //Initialize GTK and create a new window. You can replace GtkWindow with any other container widget like GtkFixed or GtkViewport etc. just make sure you position it correctly within your plugin area on the webpage.
    gtk_init(&argc, &argv);
    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    accel_group = gtk_accel_group_new(); // Initialize accelerator group to use keyboard shortcuts with "Quit" menu item.

    menu=gtk_menu_new()  ;//create a new GtkMenu widget and add its callback function using g_signal_connect which will be called every time user clicks on this menu.
    exit = gtk_menu_item_new_with_mnemonic ("Quit"); // create another nested widget for the "quit" option of the parent GtkMenu widget and use its gtk_menu_item_set_accel function to add a keyboard shortcut which will activate this menu item.
    gtk_widget_add_accelerator (exit, "activate", accel_group, GDK_KEY_q, 0x4,(GtkAccelFlags) GDK_CONTROL_MASK); // Here is the line where we pass our accelerator string in format "<Control>Q" as well as GdkEventKey data for Ctrl+Q shortcut.
    g_signal_connect(exit,"activate",G_CALLBACK(quit_cb),NULL);//registering a callback function to be invoked on activating this menu-item

    // Add the "Quit" item into our GtkMenu parent widget object and also assign it an accelerator key Ctrl+Q using gtk_accel_group_connect. After that we can display the whole menu structure by attaching it to a container like GtkButton.
    gtk_menu_append(GTK_MENU (menu), exit);
    gtk_window_add_accel_group(GTK_WINDOW (window), accel_group); // Finally register the accelerator group with this window's list of all known GdkEventKey values such as keyboard keys pressed while user is focused on our widget.

    // Add the menu to the window and show all widgets
    gtk_container_add(GTK_CONTAINER(window), menu);
    gtk_widget_show_all(window);

    // Start the GTK main loop
    gtk_main();

    return 0;
}