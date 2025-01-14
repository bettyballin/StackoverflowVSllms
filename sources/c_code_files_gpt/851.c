#include <ncurses.h>

int main() {
    initscr();              // Initialize ncurses
    WINDOW *win = newwin(10, 30, 5, 5);  // Create a new window
    box(win, 0, 0);                     // Draw a box around the window
    wrefresh(win);                      // Refresh the window to show changes
    getch();                            // Wait for a key press
    delwin(win);                        // Delete the window
    endwin();                           // Clean up ncurses
    return 0;
}