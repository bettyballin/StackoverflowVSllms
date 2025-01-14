// This is not C code, but C++ code. However, I can modify it to compile with gcc.

#include <sigc++/sigc++.h>

class MyClass {
public:
    void on_item_activated(void* pItem) {
        // Implementation of on_item_activated
    }
};

int main() {
    MyClass* obj = new MyClass();
    void* pItem = NULL; // Initialize pItem with some value
    obj->signal_activate().connect(sigc::bind(sigc::mem_fun(*obj, &MyClass::on_item_activated), pItem));
    return 0;
}