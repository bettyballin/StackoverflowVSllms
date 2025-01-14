#include <unistd.h>

// This assumes buffer is at least x bytes long,
// and that the socket is blocking.
void ReadXBytes(int socket, unsigned int x, void* buffer)
{
    int bytesRead = 0;
    int result;
    while (bytesRead < x)
    {
        result = read(socket, buffer + bytesRead, x - bytesRead);
        if (result < 1 )
        {
            // Throw your error.
        }

        bytesRead += result;
    }
}

int main() {
    // Example usage:
    int socket = 0; // Replace with your actual socket
    unsigned int x = 10; // Replace with your actual number of bytes to read
    char buffer[x]; // Replace with your actual buffer

    ReadXBytes(socket, x, buffer);

    return 0;
}