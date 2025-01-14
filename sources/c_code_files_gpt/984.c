#include <math.h>
#include <stdio.h>
#include <stdlib.h>

#define PI 3.14159265358979323846

typedef struct {
    double x, y, z;
} Point3D;

typedef struct {
    double lat, lon;
} SphericalPoint;

Point3D sphericalToCartesian(SphericalPoint p) {
    Point3D result;
    double latRad = p.lat * PI / 180.0;
    double lonRad = p.lon * PI / 180.0;
    result.x = cos(latRad) * cos(lonRad);
    result.y = cos(latRad) * sin(lonRad);
    result.z = sin(latRad);
    return result;
}

SphericalPoint cartesianToSpherical(Point3D p) {
    SphericalPoint result;
    result.lat = atan2(p.z, sqrt(p.x * p.x + p.y * p.y)) * 180.0 / PI;
    result.lon = atan2(p.y, p.x) * 180.0 / PI;
    return result;
}

void computeVoronoiSphere(SphericalPoint *points, int numPoints) {
    // Step 1: Convert spherical points to Cartesian coordinates
    Point3D *cartesianPoints = (Point3D *)malloc(numPoints * sizeof(Point3D));
    for (int i = 0; i < numPoints; i++) {
        cartesianPoints[i] = sphericalToCartesian(points[i]);
    }

    // Step 2: Project points onto a plane (stereographic projection)
    // Implement stereographic projection here

    // Step 3: Compute planar Voronoi diagram
    // Use an existing library such as Voro++ or Qhull

    // Step 4: Map the Voronoi edges back onto the sphere
    // Implement inverse stereographic projection here

    free(cartesianPoints);
}

int main() {
    SphericalPoint points[] = {
        {0, 0}, {30, 45}, {60, 90}, {-45, 135}, {-60, -90}
    };
    int numPoints = sizeof(points) / sizeof(points[0]);

    computeVoronoiSphere(points, numPoints);
    return 0;
}