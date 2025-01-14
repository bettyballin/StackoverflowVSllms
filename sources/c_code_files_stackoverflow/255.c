pp
#include <list>
#include <iostream>

// Define a simple "item" class for demonstration purposes
class item {
public:
    bool update() {
        // Your update logic here
        return true; // Replace with actual logic
    }

    void other_code_involving() {
        // Other code involving the item
    }
};

int main() {
    std::list<item*> items;

    // Let's add some items to the list for demonstration
    for (int i = 0; i < 10; i++) {
        items.push_back(new item());
    }

    std::list<item*>::iterator i = items.begin();
    while (i != items.end())
    {
        bool isActive = (*i)->update();
        if (!isActive)
        {
            items.erase(i++);  // alternatively, i = items.erase(i);
        }
        else
        {
            (*i)->other_code_involving();
            ++i;
        }
    }

    // Clean up dynamically allocated memory
    for (item* ptr : items) {
        delete ptr;
    }

    return 0;
}