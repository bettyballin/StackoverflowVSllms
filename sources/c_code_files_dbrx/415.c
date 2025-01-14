#include <termios.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>

int main() {
    struct termios newtiostructure;
    int tempFD = open("/dev/tty", O_RDWR);
    if (tempFD < 0) {
        perror("Error opening file descriptor");
        return 1;
    }

    // Assuming InterCharTime and readBufferSize are defined somewhere
    int InterCharTime = 0; // Replace with your desired value
    int readBufferSize = 1; // Replace with your desired value

    // VTIME and VMIN are defined in termios.h
    newtiostructure.c_cc[VTIME] = InterCharTime;
    newtiostructure.c_cc[VMIN]  = readBufferSize;

    // TCSANOW is defined in termios.h
    if (tcsetattr(tempFD, TCSANOW, &newtiostructure) < 0) {
        perror("Error setting terminal attributes");
        return 1;
    }

    close(tempFD);
    return 0;
}