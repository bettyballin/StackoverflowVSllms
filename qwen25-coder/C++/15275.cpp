#include <cmath>\n#include <algorithm>\n#include <iostream>\n\nvoid drawPixel(int x, int y, float bright) {\n    // Set pixel at (x, y) with brightness `bright`\n    std::cout << "(" << x << ", " << y << ") brightness: " << bright << "\n";\n}\n\nvoid XiaolinWuCircle(int xc, int yc, int r) {\n    int x = 0;\n    int y = r;\n    float d1 = 3 - 2 * r;\n    drawCirclePoints(xc, yc, x, y);\n    \n    while (y >= x) {\n        // for each pixel we will\n        // draw all eight pixels\n        \n        x++;\n\n        // check for decision parameter\n        if (d1 > 0) {\n            y--;\n            d1 = d1 + 4 * (x - y) + 10;\n        }\n        else\n            d1 = d1 + 4 * x + 6;\n\n        drawCirclePoints(xc, yc, x, y);\n    }\n}\n\nvoid drawCirclePoints(int xc, int yc, int x, int y) {\n    // Gradient values for the eight points\n    float w_x = x / std::sqrt(x*x + y*y);\n    float w_y = y / std::sqrt(x*x + y*y);\n    \n    drawPixel(xc+x, yc+y, 1-w_x); // first quadrant\n    drawPixel(xc-x, yc+y, 1+w_x); // second quadrant\n    drawPixel(xc-x, yc-y, 1+w_y); // third quadrant\n    drawPixel(xc+x, yc-y, 1-w_y); // fourth quadrant\n    \n    drawPixel(xc+y, yc+x, 1-w_y); // first quadrant with x and y swapped\n    drawPixel(xc-y, yc+x, 1+w_y); // second quadrant with x and y swapped\n    drawPixel(xc-y, yc-x, 1+w_x); // third quadrant with x and y swapped\n    drawPixel(xc+y, yc-x, 1-w_x); // fourth quadrant with x and y swapped\n}\n\nint main() {\n    int xc = 0, yc = 0, r = 25;\n    XiaolinWuCircle(xc, yc, r);\n    return 0;\n}