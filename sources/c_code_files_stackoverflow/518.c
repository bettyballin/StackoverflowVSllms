#include <functional>
#include <list>

// Assuming Foo is a class
class Foo {
public:
    ~Foo() {} // Destructor
};

// deleteAll function
static bool deleteAll(Foo* theElement) {
    delete theElement;
    return true;
}

int main() {
    std::list<Foo*> foo_list;

    // Add some elements to the list
    foo_list.push_back(new Foo());
    foo_list.push_back(new Foo());

    // Use remove_if with deleteAll function
    foo_list.remove_if(deleteAll);

    return 0;
}