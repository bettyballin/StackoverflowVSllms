#include <glib.h>
#include <windows.h>

int main() {
    GIOChannel *channel;
    GPollFD poll_fd;
    GError *error = NULL;
    HANDLE hFile;

    // Create or open a file as an example
    hFile = CreateFile("example.txt", GENERIC_READ | GENERIC_WRITE, 0, NULL, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);
    if (hFile == INVALID_HANDLE_VALUE) {
        g_print("Error opening file: %lu\n", GetLastError());
        return 1;
    }

    // Create a GLib I/O channel for the file handle
    channel = g_io_channel_win32_new_fd((int)hFile);
    if (!channel) {
        g_print("Error creating GIOChannel\n");
        CloseHandle(hFile);
        return 1;
    }

    // Initialize the GPollFD structure
    g_io_channel_win32_make_pollfd(channel, G_IO_IN | G_IO_OUT, &poll_fd);

    // Poll the file descriptor for events
    if (g_poll(&poll_fd, 1, -1) > 0) {
        if (poll_fd.revents & G_IO_IN) {
            g_print("Data is available to read\n");
        }
        if (poll_fd.revents & G_IO_OUT) {
            g_print("Ready for writing\n");
        }
    }

    // Clean up
    g_io_channel_unref(channel);
    CloseHandle(hFile);

    return 0;
}