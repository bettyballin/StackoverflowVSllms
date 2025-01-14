#include <iostream>

template <typename T>
class TMyPointTemplate {
public:
    TMyPointTemplate(T x, T y) : x_(x), y_(y) {}

    TMyPointTemplate Interpolate(const TMyPointTemplate &OtherPoint) const {
        // Assuming interpolation is done by averaging the coordinates
        return TMyPointTemplate((x_ + OtherPoint.x_) / 2, (y_ + OtherPoint.y_) / 2);
    }

    void print() const {
        std::cout << "(" << x_ << ", " << y_ << ")" << std::endl;
    }

private:
    T x_;
    T y_;
};

int main() {
    TMyPointTemplate<double> p1(1.0, 2.0);
    TMyPointTemplate<double> p2(3.0, 4.0);

    TMyPointTemplate<double> interpolated = p1.Interpolate(p2);
    interpolated.print();

    return 0;
}