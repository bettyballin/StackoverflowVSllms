#include <iostream>\n#include <algorithm>\n\nvoid reverseWords(char* s) {\n    // Helper function to reverse a portion of the array\n    auto reverseRange = [](char* begin, char* end) {\n        while (begin < end) {\n            std::swap(*begin++, *end--);\n        }\n    };\n\n    // Step 1: Reverse the entire string\n    char* start = s;\n    char* end = s;\n    while (*end) ++end; // move end to the null terminator\n    reverseRange(start, end - 1);\n\n    // Step 2: Reverse each word in the reversed string\n    start = end = s;\n    while (*start) {\n        while (*end && *end != ' ') ++end; // find the space or end\n        reverseRange(start, end - 1);\n        if (*end == ' ') {\n            start = end + 1; // move to the next word\n        }\n        ++end;\n    }\n}\n\nint main() {\n    char s[] = "this is a string";\n    std::cout << "Original: " << s << '\n';\n    reverseWords(s);\n    std::cout << "Reversed words: " << s << '\n';\n}