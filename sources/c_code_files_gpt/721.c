typedef struct _TEST {
    int cbSize;
    // other members follow
} TEST, *PTEST;

void SomeFunction(TEST* pTest) {
    if (pTest->cbSize != sizeof(TEST)) {
        // Handle the error
        return;
    }

    // Use the structure
}

int main() {
    TEST t;
    t.cbSize = sizeof(TEST);
    // Initialize other members of t

    SomeFunction(&t);

    return 0;
}