++
#include <iostream>
#include <map>
#include <string>
#include <functional>

void exit_me() {
    std::exit(0);
}

void help() {
    std::cout << "This is the help menu." << std::endl;
}

int main() {
    std::map<std::string, std::function<void()>> menu;
    menu["exit"] = exit_me;
    menu["help"] = help;

    std::string choice;
    for(;;) {
        std::cout << "Please choose: " << std::endl;
        for (const auto& it : menu) {
            std::cout << it.first << std::endl;
        }

        std::cin >> choice;
        if(menu.find(choice) == menu.end()) {
            std::cout << "Invalid choice. Please choose again." << std::endl;
            continue;
        }   

        menu[choice]();
    }

    return 0;
}