#include <ncurses.h>

int main() {
    initscr(); // Initialize ncurses

    start_color();
    init_pair(1, COLOR_RED, COLOR_BLACK);
    attron(COLOR_PAIR(1));
    printw("Red text on black background");
    attroff(COLOR_PAIR(1));

    refresh(); // Refresh the screen
    getch();   // Wait for a key press
    endwin();  // End ncurses mode

    return 0;
}