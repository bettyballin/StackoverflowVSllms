#include <stdio.h>

typedef struct _CGPoint {
    double x;
    double y;
} CGPoint;

typedef struct _CGSize {
    double width;
    double height;
} CGSize;

typedef struct _CGRect {
    CGPoint origin;
    CGSize size;
} CGRect;

typedef enum _NSComparisonResult {
    NSOrderedAscending = -1,
    NSOrderedSame,
    NSOrderedDescending
} NSComparisonResult;

static inline NSComparisonResult CGRectCompareRowsFirst(const void *s1, const void *s2) {
    CGRect r1 = *(CGRect *)s1, r2 = *(CGRect *)s2;

    if (r1.origin.y < r2.origin.y)
        return NSOrderedAscending;
    else if (r1.origin.y > r2.origin.y)
        return NSOrderedDescending;
    else {
        if (r1.origin.x < r2.origin.x)
            return NSOrderedAscending;
        else if (r1.origin.x > r2.origin.x)
            return NSOrderedDescending;
        else
            return NSOrderedSame;
    }
}

static void quick(CGRect *left, CGRect *right, NSComparisonResult(*f)(const void *, const void *)) {
    if (right > left) {
        CGRect pivot = left[(right - left) / 2];
        CGRect *r = right, *l = left;
        do {
            while (f(&*l, &pivot) == NSOrderedAscending) l++;
            while (f(&*r, &pivot) == NSOrderedDescending) r--;
            if (l <= r) {
                CGRect t = *l;
                *l++ = *r;
                *r-- = t;
            }
        } while (l <= r);
        quick(left, r, f);
        quick(l, right, f);
    }
}

static void CGRectSortRowsFirst(CGRect *array, int length) {
    quick(array, array + length - 1, CGRectCompareRowsFirst);
}

int main() {
    // Example usage:
    CGRect rects[] = {
        {{1.0, 2.0}, {10.0, 20.0}},
        {{3.0, 1.0}, {30.0, 10.0}},
        {{2.0, 3.0}, {20.0, 30.0}},
    };
    int length = sizeof(rects) / sizeof(rects[0]);

    CGRectSortRowsFirst(rects, length);

    for (int i = 0; i < length; i++) {
        printf("Rect %d: (%f, %f), (%f, %f)\n", i, rects[i].origin.x, rects[i].origin.y, rects[i].size.width, rects[i].size.height);
    }

    return 0;
}