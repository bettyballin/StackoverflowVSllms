template <typename T, typename U> struct MyStruct {\n    T aType;\n    U anotherType;\n\n    // Declare the class as a friend by specifying the template parameters\n    template <typename X, typename Y>\n    friend class IWantToBeFriendsWithMyStruct;\n};\n\nclass IWantToBeFriendsWithMyStruct\n{\nprivate:\n    int exampleVariable; // For demonstration\n\n    // Example function that might use MyStruct's private members\n    void demonstrate(MyStruct<int, double> myStruct) {\n        myStruct.aType = 42;          // Can access aType of MyStruct\n        myStruct.anotherType = 3.14;  // Can access anotherType of MyStruct\n    }\n};