#include <ncurses.h> // for ncurses functions and constants
#include <stdio.h>   // for printf function

int main() {
    // Initialize ncurses
    initscr();  // initialize the curses library, allocate resources and create a new window
    noecho();   // prevent characters typed by the user from being echoed to stdout
    curs_set(0);    // hide cursor
    refresh();     // update screen
    move(0, 0);    // move cursor (y-position=0, x-position=0)
    refresh();     // print all output to screen

    // your printf statements here
    // Note: you should use printw or addstr instead of printf in ncurses
    printw("Hello, world!\n");
    refresh();

    // Clean up
    getch();     // wait for a key press
    endwin();    // deallocate resources and end the curses application

    return 0;
}