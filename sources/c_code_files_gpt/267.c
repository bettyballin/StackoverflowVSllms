#include <curses.h>

char * decode_input(int ch)
{
        switch(ch) {
                case 'g':
                        return "get";
                        break;
                case KEY_F(9):
                        return "quit";
                        break;
                default:
                        return "unknown";
                        break;
        }
}

int main() {
    initscr(); // Initialize curses
    noecho(); // Don't echo input
    keypad(stdscr, TRUE); // Enable function keys

    int ch = getch(); // Get a character from the user
    char *decoded = decode_input(ch);

    printw("Decoded input: %s\n", decoded);
    refresh();

    getch(); // Wait for a key press before exiting
    endwin(); // Clean up curses

    return 0;
}