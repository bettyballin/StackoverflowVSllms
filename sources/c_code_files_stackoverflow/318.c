pp
#include <iostream>

class basic_thread {
public:
    virtual void action_callback() = 0;
};

class print_some : public basic_thread {
private:
    int i;
public:
    print_some(int i) : i(i) {}
    void action_callback() override {
        std::cout << i << std::endl;
    }
};

int main() {
    print_some printer(155);
    printer.action_callback();
    return 0;
}