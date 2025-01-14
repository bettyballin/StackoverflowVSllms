pp
namespace ns {
    class A; // just tell the compiler to expect a class def
}

class ns::A {
    // define here
};

int main() {
    return 0;
}