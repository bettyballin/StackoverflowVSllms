template <typename T, typename U> struct MyStruct {\n    T aType;\n    U anotherType;\n};\n\nclass IWantToBeFriendsWithMyStruct\n{\n    template <typename T, typename U> friend struct MyStruct; // specify template parameters\n};