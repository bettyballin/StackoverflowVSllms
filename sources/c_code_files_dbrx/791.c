#include <termios.h>
#include <unistd.h>

int main() {
    int tempFD; // assuming this is already set up elsewhere in your code
    struct termios newtio;

    // assuming newtio is already initialized elsewhere in your code
    tcsetattr(tempFD, TCSANOW, &newtio);
    return 0;
}