++
#include <iostream>
#include <memory>

namespace {
    struct A {
        virtual void f()
        {
            std::cout<<"inside A's f()
";
        }

        template <typename T> void f(T t)
        {
            std::cout<<T::i<<'\t';
            this->f();
        }
    };

    struct B : A {
        void f()
        {
            std::cout<<"hello\t";
            A::f();
        }
    };

    struct C {
        static const unsigned int i = 5;
    };

    struct D {
        enum { i = 6 };
    };
}

int main()
{
    std::auto_ptr<A> b(new B());
    b->f(C());
    b->f(D());
    return 0;
}