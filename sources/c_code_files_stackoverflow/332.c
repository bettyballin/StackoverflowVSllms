#include <SDL2/SDL.h>

typedef enum {
    ENTERED,
    ESCAPED,
    NOTHING
} Result;

int main() {
    SDL_Event event;
    Result lastResult = NOTHING;
    char input[256] = "";
    SDLKey lastKey;

    // Assuming SDL is initialized and a window is created
    while (SDL_PollEvent(&event)) {
        if (event.type == SDL_KEYDOWN) {
            lastKey = event.key.keysym.sym;
            if (lastKey == SDLK_RETURN)
                lastResult = ENTERED;
            else if (lastKey == SDLK_ESCAPE)
                lastResult = ESCAPED;
            else if (lastKey >= SDLK_SPACE && lastKey <= SDLK_z) {
                // Note: static_cast is a C++ feature, using C-style cast instead
                char c = (char) lastKey;
                strncat(input, &c, 1);
                lastResult = NOTHING;
            }
        }
    }

    return 0;
}