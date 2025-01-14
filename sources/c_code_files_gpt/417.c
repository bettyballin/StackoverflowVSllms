#include <ncurses.h>
#include <panel.h>

int main() {
    initscr();                    // Initialize ncurses

    WINDOW *win = newwin(10, 30, 5, 5);
    PANEL *panel = new_panel(win);  // Create a panel from a window
    update_panels();               // Refresh panels to reflect changes

    doupdate();                   // Show it on the screen
    getch();                      // Wait for a key press
    endwin();                     // Clean up

    return 0;
}