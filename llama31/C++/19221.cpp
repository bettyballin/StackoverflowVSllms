#include <cmath>\n\nstd::pair<double, double> calculatePoint(double radius, double angle, std::pair<double, double> origin = {0, 0}) {\n    double x = radius * std::cos(angle) + origin.first;\n    double y = radius * std::sin(angle) + origin.second;\n    return {x, y};\n}