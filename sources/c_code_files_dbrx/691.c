#include <ncurses.h>
#include <stdio.h>

int main(void) {
    int ch;
    initscr(); // initialize the screen for ncurses
    raw();  // make special keys (e.g., arrow keys, etc.) available
    keypad(stdscr, TRUE); // Enable capture of function key
    noecho(); // do not display key presses on-screen
    while((ch = getch()) != KEY_F(1) ) {  // F1 to exit
        if (ch == KEY_UP)      printf("\nUP ARROW ");
        else if (ch == KEY_DOWN)   printf("\nDOWN ARROW");
        else if (ch == KEY_LEFT)   printf("\nLEFT ARROW");
        else if (ch == KEY_RIGHT)  printf("\nRIGHT ARROW");
    }
    endwin(); // clean up ncurses resources
    return 0; // added return statement
}