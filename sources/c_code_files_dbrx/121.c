#include <gtk/gtk.h>
#include <time.h> // Include this for timespec and nanosleep

int main( int argc, char *argv[] ) {
   GtkWidget *window;

   gtk_init(&argc, &argv);

   window = gtk_window_new (GTK_WINDOW_TOPLEVEL);
   /* To position the window */
   gtk_window_move(GTK_WINDOW(window), 10, 20); //X=10 and Y=20 for dummy here adjust as required.

   gtk_widget_show (window);
   // Sleep to let GTK render window contents etc., replace nanosleep with sleep as needed.
   struct timespec tv = { .tv_sec = 2, .tv_nsec = 0 }; /* delay in seconds */
   nanosleep (&tv , NULL); // wait for a couple of seconds before capturing the screenshot

   gtk_main ();
   return(0);
}