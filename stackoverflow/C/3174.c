struct Customer {\n    int id;\n    std::string first_name;\n    std::string last_name;\n    struct {\n        std::string street;\n        std::string unit;\n    } address;\n    char state[2];\n    int zip;\n};