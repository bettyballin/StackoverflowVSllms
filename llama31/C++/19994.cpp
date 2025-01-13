// Load image strip from file\nSDL_Surface* imageStrip = SDL_LoadBMP("image_strip.bmp");\n\n// Define a struct to represent a single image in the strip\nstruct Image {\n    int x, y; // Position within the strip\n    int width, height; // Dimensions of the image\n};\n\n// Create an array of Image structs to represent the individual images\nImage images[10];\n\n// Initialize the images array\nfor (int i = 0; i < 10; i++) {\n    images[i].x = i * 32; // Assuming 32x32 images\n    images[i].y = 0;\n    images[i].width = 32;\n    images[i].height = 32;\n}\n\n// Use the images array to access individual images within the strip\nSDL_Rect srcRect = { images[0].x, images[0].y, images[0].width, images[0].height };\nSDL_Rect dstRect = { 0, 0, images[0].width, images[0].height };\nSDL_BlitSurface(imageStrip, &srcRect, screenSurface, &dstRect);