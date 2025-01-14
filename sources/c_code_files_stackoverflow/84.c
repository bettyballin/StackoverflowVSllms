#include <vector>
#include <algorithm>

template <typename T>
struct pointer_values_equal
{
    const T* to_find;

    bool operator()(const T* other) const
    {
        return *to_find == *other;
    }
};

// Define a simple class A
class A
{
public:
    A(const char* str) : str_(str) {}

    bool operator==(const A& other) const
    {
        return strcmp(str_, other.str_) == 0;
    }

private:
    const char* str_;
};

// usage:
void test(const std::vector<A*>& va)
{
    A* to_find = new A("two");
    pointer_values_equal<A> eq = { to_find };
    std::find_if(va.begin(), va.end(), eq);
    // don't forget to delete A!
    delete to_find;
}

int main()
{
    std::vector<A*> va;
    // Add some elements to the vector...
    va.push_back(new A("one"));
    va.push_back(new A("two"));
    va.push_back(new A("three"));

    test(va);

    // Clean up
    for (auto p : va) {
        delete p;
    }

    return 0;
}