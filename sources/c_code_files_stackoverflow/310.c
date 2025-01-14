pp
#include <iostream>

class Point {
public:
    int x, y;

    Point(int x = 0, int y = 0) : x(x), y(y) {}
};

class Rect {
public:
    int x, y, w, h;

    Rect(int x = 0, int y = 0, int w = 0, int h = 0) : x(x), y(y), w(w), h(h) {}

    bool contains(const Point& p) {
        return (p.x >= x && p.x <= x + w && p.y >= y && p.y <= y + h);
    }
};

int main() {
    Rect r(1, 1, 5, 5);
    Point p(3, 3);

    if (r.contains(p)) {
        std::cout << "Point is inside the rectangle." << std::endl;
    } else {
        std::cout << "Point is outside the rectangle." << std::endl;
    }

    return 0;
}