#include <gtk/gtk.h>

// Assuming plugin() and workbook() are functions that return a gtk object and a workbook object respectively
// Also assuming that this->signals[NOTEBOOK_SWITCHPAGE] is a valid callback function

void connect_signal() {
    gtk_signal_connect (GTK_OBJECT (plugin()->workbook()->gtk_workbook), "switch-page",
        (GtkSignalFunc)this->signals[NOTEBOOK_SWITCHPAGE], plugin()->workbook());
}