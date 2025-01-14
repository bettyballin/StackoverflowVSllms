#include <math.h>

typedef struct {
    float x, y, z;
} Vector3;

float dot(const Vector3 *a, const Vector3 *b) {
    return a->x * b->x + a->y * b->y + a->z * b->z;
}

bool ray_sphere_intersection(const Vector3 *d, const Vector3 *f, float r) {
    float a = dot(d, d);
    float b = 2 * dot(f, d);
    float c = dot(f, f) - r * r;

    float discriminant = b * b - 4 * a * c;
    if (discriminant < 0) {
        // no intersection
        return false;
    } else {
        discriminant = sqrt(discriminant);

        float t1 = (-b - discriminant) / (2 * a);
        float t2 = (-b + discriminant) / (2 * a);

        if (t1 >= 0 && t1 <= 1) {
            // Impale, Poke
            return true;
        }

        if (t2 >= 0 && t2 <= 1) {
            // ExitWound
            return true;
        }

        // no intersection: FallShort, Past, CompletelyInside
        return false;
    }
}