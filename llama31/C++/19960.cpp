std::string wordWrap(const std::string& sentence, int width)\n{\n    std::string result;\n    std::string::const_iterator it = sentence.begin();\n    int distanceToWidth = 0;\n\n    while (it != sentence.end())\n    {\n        while (it != sentence.end() && distanceToWidth < width)\n        {\n            result += *it;\n            distanceToWidth++;\n            it++;\n        }\n\n        if (distanceToWidth >= width)\n        {\n            result += '\n';\n            distanceToWidth = 0;\n        }\n    }\n\n    return result;\n}