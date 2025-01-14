// Renamed to .cpp to compile with gcc as C++ code
// Compile with: gcc -c -o myclass.o myclass.cpp -lstdc++

class MyClass {
public:
    void foo(int);
    int bar(int);
    double bar(double);
    void baz(MyClass);
};

// Function definitions added to avoid linker errors
void MyClass::foo(int) {}
int MyClass::bar(int) { return 0; }
double MyClass::bar(double) { return 0.0; }
void MyClass::baz(MyClass) {}

int main() {
    return 0;
}