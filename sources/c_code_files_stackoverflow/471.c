#include <gtk/gtk.h>
#include <stdbool.h>

typedef struct {
    int type;
    int result;
} DialogData;

// Define MB_YESNO if not defined elsewhere
#ifndef MB_YESNO
#define MB_YESNO 1
#endif

static gboolean
display_dialog(gpointer user_data)
{
    DialogData *dialog_data = user_data;
    GtkWidget *dialog;

    // Using GTK3 approach to create a message dialog
    if (dialog_data->type & MB_YESNO)
        dialog = gtk_message_dialog_new(NULL, GTK_DIALOG_MODAL, GTK_MESSAGE_QUESTION, GTK_BUTTONS_YES_NO, "Yes or No question");
    else
        dialog = gtk_message_dialog_new(NULL, GTK_DIALOG_MODAL, GTK_MESSAGE_INFO, GTK_BUTTONS_OK, "Informational dialog");

    // Set title
    gtk_window_set_title(GTK_WINDOW(dialog), "Dialog");

    dialog_data->result = gtk_dialog_run(GTK_DIALOG(dialog));

    gtk_widget_destroy(dialog);

    gtk_main_quit();  // Quits the main loop run in MessageBox()

    return FALSE;
}

int MessageBox(int type)
{
    DialogData dialog_data;

    dialog_data.type = type;

    gtk_idle_add(display_dialog, &dialog_data);

    gtk_main();

    // Do stuff based on dialog_data.result
    g_print("Result: %d\n", dialog_data.result);

    return 0;
}

int main(int argc, char *argv[])
{
    gtk_init(&argc, &argv);

    MessageBox(MB_YESNO);

    return 0;
}