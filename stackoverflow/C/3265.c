/* Changed: Code formatted for my sanity */\n\n#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n#include <fcntl.h>\n#include <errno.h>\n#include <string.h>\n\n/*global definitions*/\n#define WIDTH 480\n#define HEIGHT 240\n\n/*global declarations*/\nint w,h,scrn, bytewrite;\n/* Changed: to a short because I don't like the fact that I might be overwriting\n   memory on accident (in colorq). */\nunsigned short red, green, blue;\nstatic unsigned long rgb[WIDTH][HEIGHT];\n\n/* Changed: Some format strings have been changed to get rid of compiler\n   warnings. */\n\n/*function declarations*/\nvoid colorq();\n/* Changed: Specify the second dimension when you're passing an array. */\nvoid rgb_rectdraw(int x, int y, int w, int h, unsigned char red,\n                  unsigned char green, unsigned char blue,\n                  unsigned long rgb[][HEIGHT]);\n/* Changed: always pass an array of arrays. */\nvoid rgb2yuv(unsigned long rgb[][HEIGHT]);\n\n\n/*\n   Function Name: main\n   Purpose: main function\n */\n\nint main(int argc, char** argv)\n{\n    printf("\n");\n    int x, y;\n\n\n    /*call colorq to create a 32bit number of RGB*/\n    colorq();\n\n\n    /* call rgb_rectdraw to draw a rectangle RGB array */\n    rgb_rectdraw(x, y, w, h, red, green, blue, rgb);\n\n    /* call rgb2yuv to take the RGB array and covert it to a YUV array */\n    rgb2yuv(rgb);\n\n    return 0;\n}\n\n/*\n   Function name: color q\n   Purpose: asks user to input colors from 0 to 255 in RGB format\n */\n\nvoid colorq(){\n    /* Suggestion: restructure this method to just take in all its input\n       locally, then return a rgbpixel. */\n\n    printf("Please enter a color for Red Green and Blue from 0 to 255:\n");\n    scanf("%hu", &red);\n    scanf("%hu", &green);\n    scanf("%hu", &blue);\n    printf("\n");\n\n    return;\n}\n\n\n\n/*\n   Function name: rectdraw\n   Purpose: Draws a rectangle array\n */\n\nvoid rgb_rectdraw(int x, int y, int w, int h,unsigned char red,\n                  unsigned char green, unsigned char blue,\n                  unsigned long rgb[][HEIGHT])\n{\n    unsigned long rgbpixel;\n\n    /* testing only take out when\n       finished debugging why red is always 0 after scanf */\n    red = 255;\n    printf("red set to 255 for debugging\n");\n\n    /*creates a 32-bit number of RGB*/\n    /* Changed: Added the extra 0xFF masking because of shortness rather than\n       charness. */\n    rgbpixel = ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | (blue & 0xFF);\n    printf("%#lx\n",rgbpixel);\n\n    /*create array of width w height h*/\n    /*initialize array*/\n\n    /* Changed: fill the size of one element times the number of elements */\n    memset(rgb, 0, sizeof(unsigned long) * HEIGHT * WIDTH);\n    int i, j, startx, stopx, starty, stopy;\n\n\n    printf("enter width and height of rectangle in pixels\n");\n    scanf("%d %d", &w, &h);\n\n    printf("enter offset x pixels and y pixels of rectangle:\n");\n    scanf("%d %d", &x, &y);\n\n    startx=x;\n    starty=y;\n    stopx=x+w;\n    stopy=y+w;\n\n    /* creates array of w and h of int rgh */\n    for(i=startx; i <= stopx; i++){\n        for(j=starty; j <= stopy; j++){\n            rgb[i][j] = rgbpixel;\n        }\n        j = 0;\n    }\n    printf("original rgb %#lx\n", (long unsigned int) rgb);\n    return ;\n}\n\n/*\n *Function Name: rgb2yuv\n *Purpose: convert the RGB array to a YUV array\n */\n\nvoid rgb2yuv(unsigned long  rgb[][HEIGHT]){\n\n    int i,j;\n    /* Changed: You can't just dereference rgb twice -- you have to use array\n       notation here. */\n    printf("ptrpassed = %#lx\n", rgb[0][0]);\n    for(i=0; i<=WIDTH; i++){\n        for(j=0; j<=HEIGHT; j++){\n        }\n    }\n    printf("\n");\n    return;\n}