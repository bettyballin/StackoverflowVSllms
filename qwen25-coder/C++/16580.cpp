#include <iostream>\n#include <csignal>\n\nvoid cleanup() {\n    std::cout << "Cleaning up before exit..." << std::endl;\n    // Close files or perform other cleanup tasks here\n}\n\nvoid signalHandler(int signum) {\n    std::cout << "Interrupt signal received (" << signum << ")." << std::endl;\n    cleanup();\n    exit(signum);  \n}\n\nint main() {\n    // Register signal SIGINT (Ctrl+C) and signal handler\n    signal(SIGINT, signalHandler);\n\n    std::cout << "Program running. Press Ctrl+C to end." << std::endl;\n\n    while(1) {\n        // Program doing something useful\n    }\n\n    return 0;\n}