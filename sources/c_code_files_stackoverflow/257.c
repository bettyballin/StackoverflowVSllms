#include <iostream>

class Point {
public:
    int getX() const { return x; }
    void setX(int value) { x = value; }

    int getY() const { return y; }
    void setY(int value) { y = value; }

private:
    int x;
    int y;
};

struct PointXAccessor {
    static int get(const Point& p) { return p.getX(); }
    static void set(Point& p, int value) { p.setX(value); }
};

struct PointYAccessor {
    static int get(const Point& p) { return p.getY(); }
    static void set(Point& p, int value) { p.setY(value); }
};

template <class PointAccessor>
int someAlgorithm(Point& p) {
    // implementation of someAlgorithm
    int value = PointAccessor::get(p);
    // do something with value
    PointAccessor::set(p, value * 2);
    return value;
}

int main() {
    Point p;
    p.setX(10);
    p.setY(20);

    std::cout << "X before: " << p.getX() << std::endl;
    someAlgorithm<PointXAccessor>(p);
    std::cout << "X after: " << p.getX() << std::endl;

    std::cout << "Y before: " << p.getY() << std::endl;
    someAlgorithm<PointYAccessor>(p);
    std::cout << "Y after: " << p.getY() << std::endl;

    return 0;
}