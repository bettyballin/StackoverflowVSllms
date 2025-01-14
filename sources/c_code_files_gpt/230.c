#include <gtk/gtk.h>
#include <windows.h>

// Define Windows constants for GTK
#define MB_YESNO 4
#define IDYES 6
#define IDNO 7
#define IDOK 1

int MessageBox(HWND hwnd, const char* text, const char* caption, UINT type)
{
    GtkWidget *dialog;
    
    gtk_init(0, NULL);

    if (type & MB_YESNO) {
        dialog = gtk_message_dialog_new(NULL, GTK_DIALOG_DESTROY_WITH_PARENT, GTK_MESSAGE_QUESTION, GTK_BUTTONS_YES_NO, "%s", text);
    } else {
        dialog = gtk_message_dialog_new(NULL, GTK_DIALOG_DESTROY_WITH_PARENT, GTK_MESSAGE_INFO, GTK_BUTTONS_OK, "%s", text);
    }

    gtk_window_set_title(GTK_WINDOW(dialog), caption);
    gint result = gtk_dialog_run(GTK_DIALOG(dialog));

    gtk_widget_destroy(dialog);

    if (type & MB_YESNO) {
        if (result == GTK_RESPONSE_YES) {
            return IDYES;
        } else {
            return IDNO;
        }
    }

    return IDOK;
}

int main() {
    MessageBox(NULL, "Hello, world!", "My Dialog", MB_YESNO);
    return 0;
}