# Compile the executable\ng++ test-sdl.cpp -o test-sdl -lSDL_image -lSDL\n\n# Get the dependencies\nldd test-sdl | grep "=>" | awk '{print $3}' | xargs -I {} cp {} .\n\n# Package the executable and dependencies\ntar -cvzf test-sdl.tar.gz test-sdl