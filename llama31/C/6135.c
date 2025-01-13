#include <stdio.h>\n\n#define WIDTH 80\n#define HEIGHT 24\n\nvoid floodfill(char *screen, int x, int y, char new_color, char old_color) {\n  int queue[WIDTH * HEIGHT][2];\n  int head = 0, tail = 0;\n\n  queue[tail][0] = x;\n  queue[tail][1] = y;\n  tail++;\n\n  while (head < tail) {\n    x = queue[head][0];\n    y = queue[head][1];\n    head++;\n\n    if (screen[y * WIDTH + x] == old_color) {\n      screen[y * WIDTH + x] = new_color;\n\n      if (x > 0) {\n        queue[tail][0] = x - 1;\n        queue[tail][1] = y;\n        tail++;\n      }\n      if (x < WIDTH - 1) {\n        queue[tail][0] = x + 1;\n        queue[tail][1] = y;\n        tail++;\n      }\n      if (y > 0) {\n        queue[tail][0] = x;\n        queue[tail][1] = y - 1;\n        tail++;\n      }\n      if (y < HEIGHT - 1) {\n        queue[tail][0] = x;\n        queue[tail][1] = y + 1;\n        tail++;\n      }\n    }\n  }\n}\n\nint main() {\n  char screen[HEIGHT][WIDTH];\n  int x, y;\n\n  // Initialize screen with some values\n  for (y = 0; y < HEIGHT; y++) {\n    for (x = 0; x < WIDTH; x++) {\n      screen[y][x] = '.';\n    }\n  }\n\n  // Create a rectangle to floodfill\n  for (y = 5; y < 10; y++) {\n    for (x = 5; x < 10; x++) {\n      screen[y][x] = '#';\n    }\n  }\n\n  // Floodfill the rectangle\n  floodfill((char *)screen, 6, 6, '*', '#');\n\n  // Print the result\n  for (y = 0; y < HEIGHT; y++) {\n    for (x = 0; x < WIDTH; x++) {\n      printf("%c", screen[y][x]);\n    }\n    printf("\n");\n  }\n\n  return 0;\n}