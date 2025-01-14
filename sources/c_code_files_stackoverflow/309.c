pp
#include <iostream>

class MenuButton {
public:
    void SetButton() {
        std::cout << "Button is set." << std::endl;
    }
};

int main() {
    MenuButton menuButton;
    menuButton.SetButton();
    return 0;
}