#include <stdio.h>
#include <X11/Xlib.h>

int main() {
    Display *d;
    Window w;
    int s;
    Colormap cmap;
    XColor xcol;
    unsigned long colour = 0xffffffff; // or any other value - this is white.

    // open connection to the server
    if ((d = XOpenDisplay(NULL)) == NULL) {
        fprintf(stderr, "Can't connect to Display.\n");
    } else {
        s = DefaultScreen(d);
        w = RootWindow(d, s); // target window ID: root
        cmap = XDefaultColormap(d, s);
        XParseColor(d, cmap, "white", &xcol);
        colour = xcol.pixel;
    }
    // set the color for the entire screen background.
    if (w != 0) XSetWindowBackground(d, w, colour);

    // Don't forget to flush the changes to the display
    XFlush(d);

    return 0;
}