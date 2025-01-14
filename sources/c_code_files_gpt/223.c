#include <curses.h>

int main() {
    int ch;

    // Initialize the curses library
    initscr();
    // Enable keypad mode
    keypad(stdscr, TRUE);
    // Don't echo input characters to the screen
    noecho();
    // Make getch() non-blocking
    timeout(0);

    printw("Press arrow keys or 'q' to quit.\n");

    while ((ch = getch()) != 'q') {
        switch (ch) {
            case KEY_UP:
                printw("Up arrow key pressed.\n");
                break;
            case KEY_DOWN:
                printw("Down arrow key pressed.\n");
                break;
            case KEY_LEFT:
                printw("Left arrow key pressed.\n");
                break;
            case KEY_RIGHT:
                printw("Right arrow key pressed.\n");
                break;
            default:
                break;
        }
        refresh();
    }

    // End curses mode
    endwin();
    return 0;
}