#include <unistd.h> // Include this for the sleep function
#include <gst/gst.h> // Include this for the GsteSlideshow type

static void
show_next_image (GstElement *self)
{
    // Code to show the next image
    // ...

    // Add a delay of 10 seconds
    sleep(10);
}

int main() {
    // Initialize GStreamer
    gst_init(NULL, NULL);

    // Create an instance of GstElement
    GstElement *slideshow = gst_element_factory_make("slideshow", "slideshow");

    // Call the show_next_image function
    show_next_image(slideshow);

    // Clean up
    gst_element_unref(slideshow);
    gst_deinit();

    return 0;
}