pp
template<class T>
void f( T k )
{
     T x( k );
     x.x();
}

class Test {
public:
    Test(int k) {}
    void x() {}
};

int main() {
    Test t(5);
    f(t);
    return 0;
}