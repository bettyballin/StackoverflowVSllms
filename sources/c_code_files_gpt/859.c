#include <stdio.h>

// Define a struct to match the one in your snippet
typedef struct {
    int length;
} rrec;

typedef struct {
    rrec *rrec;
} s3;

typedef struct {
    s3 *s3;
} ssl;

int check_length(ssl *s, int payload, int padding) {
    // Example code that was vulnerable to Heartbleed
    if (1 + 2 + payload + padding > s->s3->rrec->length) {
        return 0;
    }
    return 1; // Return something if the condition isn't met
}

int main() {
    // Create instances of the structs to pass to the function
    rrec r;
    r.length = 10;

    s3 s3_instance;
    s3_instance.rrec = &r;

    ssl s;
    s.s3 = &s3_instance;

    int payload = 5;
    int padding = 2;

    // Call the function with the created instances
    int result = check_length(&s, payload, padding);
    printf("Result: %d\n", result);

    return 0;
}