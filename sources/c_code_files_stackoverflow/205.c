pp
#include <SDL/SDL.h>
#include <vector>

typedef void (*SDLEventFunction)(SDL_Event *);

std::vector<SDLEventFunction> functions;

int main() {
    // Your code here
    return 0;
}