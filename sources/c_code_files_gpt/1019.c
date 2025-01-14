// Global variable
int globalVar;

void exampleFunction() {
    // Local variable
    int localVar;

    // gcc will warn about 'localVar' being unused
    // but will not warn about 'globalVar'
}

int main() {
    exampleFunction();
    return 0;
}