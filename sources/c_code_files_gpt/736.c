#include <curses.h>

int main() {
    initscr();            // Initialize the screen
    cbreak();             // Disable line buffering
    noecho();             // Don't echo key presses to the screen

    // Your code here

    endwin();             // End curses mode
    return 0;
}