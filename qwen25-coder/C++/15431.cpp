class testMenu : public MenuScreen {\npublic:\n    bool draw;\n    MenuButton<testMenu> x;\n\n    testMenu() : MenuScreen("testMenu") {\n        // Pass 'this' to ensure the member function can be called on this instance.\n        x.SetButton(100, 100, TEXT("buttonNormal.png"), TEXT("buttonHover.png"), TEXT("buttonPressed.png"), 100, 40, &testMenu::test2, *this);\n\n        draw = false;\n    }\n\n    void test2() {\n        draw = true;\n    }\n};\n\n// Modify your MenuButton class to accept and store the object instance\nclass MenuButton<type> { // Assuming type is a template parameter for the object class\nprivate:\n    typedef void (type::*MemberFunc)();\n    MemberFunc ButtonFunc;\n    type* obj; // Store the object pointer\n\npublic:\n    void SetButton(int xPos, int yPos, LPCWSTR normalFilePath, LPCWSTR hoverFilePath, LPCWSTR pressedFilePath, int Width, int Height, MemberFunc func, type& obj) {\n        BUTTON::SetButton(xPos, yPos, normalFilePath, hoverFilePath, pressedFilePath, Width, Height);\n\n        this->ButtonFunc = func;\n        this->obj = &obj; // Store the object pointer\n    }\n\n    // Example of how you might call the member function later\n    void CallFunction() {\n        if (obj && ButtonFunc) {\n            (obj->*ButtonFunc)();\n        }\n    }\n};