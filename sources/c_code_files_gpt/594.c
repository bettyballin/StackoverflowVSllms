#include <X11/Xlib.h>
#include <X11/Xutil.h>
#include <X11/Xos.h>
#include <png.h>
#include <cstdio>
#include <cstdlib>

void saveImageAsPNG(const char* filename, XImage* img) {
    FILE *fp = fopen(filename, "wb");
    if(!fp) {
        perror("File opening failed");
        exit(EXIT_FAILURE);
    }

    png_structp png = png_create_write_struct(PNG_LIBPNG_VER_STRING, NULL, NULL, NULL);
    if (!png) abort();

    png_infop info = png_create_info_struct(png);
    if (!info) abort();

    if (setjmp(png_jmpbuf(png))) abort();

    png_init_io(png, fp);

    png_set_IHDR(
        png,
        info,
        img->width, img->height,
        8,
        PNG_COLOR_TYPE_RGBA,
        PNG_INTERLACE_NONE,
        PNG_COMPRESSION_TYPE_DEFAULT,
        PNG_FILTER_TYPE_DEFAULT
    );
    png_write_info(png, info);

    png_bytep row = (png_bytep) malloc(4 * img->width * sizeof(png_byte));
    for(int y = 0; y < img->height; y++) {
        for(int x = 0; x < img->width; x++) {
            long pixel = XGetPixel(img, x, y);
            row[x*4 + 0] = (pixel & img->red_mask) >> 16;
            row[x*4 + 1] = (pixel & img->green_mask) >> 8;
            row[x*4 + 2] = (pixel & img->blue_mask);
            row[x*4 + 3] = 0xff;
        }
        png_write_row(png, row);
    }

    png_write_end(png, NULL);
    fclose(fp);

    if (png && info)
        png_destroy_write_struct(&png, &info);
    if (row)
        free(row);
}

int main() {
    Display* display = XOpenDisplay(nullptr);
    if (!display) {
        fprintf(stderr, "Cannot open display\n");
        return 1;
    }

    int screen = DefaultScreen(display);
    Window root = RootWindow(display, screen);

    XWindowAttributes gwa;
    XGetWindowAttributes(display, root, &gwa);

    int width = gwa.width;
    int height = gwa.height;

    XImage* img = XGetImage(display, root, 0, 0, width, height, AllPlanes, ZPixmap);
    if (img) {
        saveImageAsPNG("screenshot.png", img);
        XDestroyImage(img);
    }

    XCloseDisplay(display);
    return 0;
}