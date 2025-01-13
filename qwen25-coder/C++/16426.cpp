// Resources.h\nclass Resources {\npublic:\n    static Resources& getInstance() {\n        static Resources instance;\n        return instance;\n    }\n\nprivate:\n    Resources() { /* constructor code */ }\n    ~Resources() { /* destructor code */ }\n};\n\n// User.cpp (or another translation unit)\n#include "Resources.h"\n\nclass User {\npublic:\n    User() {\n        // constructor code\n    }\n    ~User() {\n        // Use Resources for cleanup or other tasks\n        Resources::getInstance();\n    }\n};\n\nstatic void ensureOrderOfDestruction() {\n    static User user;\n    static Resources& resources = Resources::getInstance();  // Ensure Resources is created before User and destroyed after User\n}\n\nint main() {\n    ensureOrderOfDestruction();\n    // Rest of your application code\n}