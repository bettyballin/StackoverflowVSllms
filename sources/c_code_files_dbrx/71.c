#include <SDL2/SDL.h>
#include <cairo.h>
#include <pango/pangocairo.h>
#include <glib.h>
#include <stdio.h>

// Main function where we initialize window and renderer
int main(void) {
    // Initialize video with SDL
    if (SDL_Init(SDL_INIT_VIDEO) != 0) {
        printf("Unable to initialize SDL: %s\n", SDL_GetError());
        return -1;
    }

    // Create window
    SDL_Window* window = SDL_CreateWindow("Text editor",
                          SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600,
                          0);

    if (window == NULL) {
        printf("Unable to create window: %s\n", SDL_GetError());
        return -1;
    }

    // Create renderer for the screen surface
    cairo_surface_t *cairo_screen_surface = cairo_image_surface_create(CAIRO_FORMAT_ARGB32, 800, 600);

    if (cairo_screen_surface == NULL) {
      fprintf(stderr, "Unable to create cairo SDL surface\n");
      return -1;
    }

    // Create Cairo context for rendering operations
    cairo_t *cr = cairo_create (cairo_screen_surface);
    if (cr == NULL) {
      fprintf(stderr, "Unable to create cairo context\n");
      return -1;
    }

    // Pango specific setups go here for managing text rendering with cairo.
    PangoLayout* layout;
    PangoFontDescription* font_desc = pango_font_description_new ();
    layout = pango_cairo_create_layout (cr);
    pango_layout_set_text (layout, "Your editor", -1);
    pango_cairo_update_context(cr, NULL); // Update the context before drawing.
    cairo_move_to (cr, 50, 50); /* Position of text to draw */
    pango_cairo_show_layout(cr, layout) ; /* Draw the text using Pango and Cairo on screen surface */

    // Cleaning up contexts before quitting.
    g_object_unref (layout);
    cairo_surface_destroy (cairo_screen_surface);
    cairo_destroy(cr);

    SDL_DestroyWindow(window);
    SDL_Quit();
    return 0;
}