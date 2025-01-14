#include <stdbool.h>

// Function to check if three points are collinear
bool areCollinear(int x1, int y1, int x2, int y2, int x3, int y3) {
    return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
}

// Function to remove duplicates and collinear points
void preprocessPolygon(int* x, int* y, int* n) {
    int new_n = 0;
    for (int i = 0; i < *n; ++i) {
        if (i == 0 || (x[i] != x[new_n - 1] || y[i] != y[new_n - 1])) {
            if (new_n < 2 || !areCollinear(x[new_n - 2], y[new_n - 2], x[new_n - 1], y[new_n - 1], x[i], y[i])) {
                x[new_n] = x[i];
                y[new_n] = y[i];
                new_n++;
            }
        }
    }
    *n = new_n;
}

// Example usage
int main() {
    int x[] = {0, 1, 2, 3, 4};
    int y[] = {0, 1, 2, 3, 4};
    int n = 5;

    preprocessPolygon(x, y, &n);

    // Now x and y contain the preprocessed points, and n is the new number of points
    return 0;
}