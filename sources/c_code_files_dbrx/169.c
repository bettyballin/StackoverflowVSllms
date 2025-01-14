#include <curses.h>

const char * decode_input(int key)
{
        switch(key) {
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
    initscr(); // Initialize curses mode
    noecho();  // Don't echo any keypresses
    keypad(stdscr, TRUE); // Enable the keypad for function keys
    int c = getch(); // Get a character from the user
    const char *action = decode_input(c);
    addstr(action); // Print the action
    refresh(); // Refresh the screen
    getch(); // Wait for a key press
    endwin(); // Clean up curses
    return 0;
}