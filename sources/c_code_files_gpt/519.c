#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Define the Point structure
typedef struct Point {
    double values[2]; // Assuming 2D points
} Point;

// Function to get the value of a point at a specific axis
double getValue(Point* point, unsigned int axis) {
    return point->values[axis];
}

// Define the Node structure
typedef struct Node {
    unsigned int axis;
    Point* obj;
    struct Node* left;
    struct Node* right;
} Node;

// Function to set the order of points based on their distances to a target point
void _setOrder(Point* to, Point* obj, Point** first, Point** second, Point** third) {
    // Calculate distances from "to" to the current best points
    double distFirst = sqrt(pow(to->values[0] - (*first)->values[0], 2) + pow(to->values[1] - (*first)->values[1], 2));
    double distSecond = sqrt(pow(to->values[0] - (*second)->values[0], 2) + pow(to->values[1] - (*second)->values[1], 2));
    double distThird = sqrt(pow(to->values[0] - (*third)->values[0], 2) + pow(to->values[1] - (*third)->values[1], 2));

    // Calculate distance from "to" to the new object
    double distObj = sqrt(pow(to->values[0] - obj->values[0], 2) + pow(to->values[1] - obj->values[1], 2));

    // Update the order of points if necessary
    if (distObj < distFirst) {
        *third = *second;
        *second = *first;
        *first = obj;
    } else if (distObj < distSecond) {
        *third = *second;
        *second = obj;
    } else if (distObj < distThird) {
        *third = obj;
    }
}

// Function to find the largest distance between a point and a set of points
double _largestDistance(Point* to, Point* first, Point* second, Point* third) {
    double distFirst = sqrt(pow(to->values[0] - first->values[0], 2) + pow(to->values[1] - first->values[1], 2));
    double distSecond = sqrt(pow(to->values[0] - second->values[0], 2) + pow(to->values[1] - second->values[1], 2));
    double distThird = sqrt(pow(to->values[0] - third->values[0], 2) + pow(to->values[1] - third->values[1], 2));

    return (distFirst > distSecond) ? ((distFirst > distThird) ? distFirst : distThird) : ((distSecond > distThird) ? distSecond : distThird);
}

// Function to find the closest points to a target point in a k-d tree
void _findClosest(Node* current, Point* to, Point** first, Point** second, Point** third, unsigned int depth) {
    if (current == NULL) return;

    if (current->left == NULL && current->right == NULL) {
        _setOrder(to, current->obj, first, second, third);
        return;
    }

    unsigned int axis = depth % 2;
    Node* other = NULL;

    if (to->values[axis] < current->obj->values[axis]) {
        other = current->right;
        _findClosest(current->left, to, first, second, third, depth + 1);
    } else {
        other = current->left;
        _findClosest(current->right, to, first, second, third, depth + 1);
    }

    _setOrder(to, current->obj, first, second, third);

    if (other == NULL) return;

    double searchToBest = _largestDistance(to, *first, *second, *third);
    double searchToSplit = fabs(to->values[axis] - current->obj->values[axis]);

    if (searchToBest >= searchToSplit) {
        _findClosest(other, to, first, second, third, depth + 1);
    }
}

int main() {
    // Example usage
    Point point = {{1.0, 2.0}};
    Point* first = NULL;
    Point* second = NULL;
    Point* third = NULL;

    Node* root = (Node*)malloc(sizeof(Node));
    root->axis = 0;
    root->obj = &point;
    root->left = NULL;
    root->right = NULL;

    _findClosest(root, &point, &first, &second, &third, 0);

    return 0;
}