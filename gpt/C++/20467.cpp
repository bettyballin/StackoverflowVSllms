#include <iostream>\n#include <csignal>\n#include <cstdlib>\n\n// Function to be called when SIGINT is received\nvoid signalHandler(int signum) {\n    std::cout << "Interrupt signal (" << signum << ") received.\n";\n    \n    // Cleanup and close up stuff here\n    // Close files, release resources, etc.\n\n    // Terminate the program\n    exit(signum);\n}\n\nint main() {\n    // Register the signal handler for SIGINT\n    signal(SIGINT, signalHandler);\n\n    // Infinite loop to keep the program running\n    while(true) {\n        std::cout << "Running...\n";\n        sleep(1);\n    }\n\n    return 0;\n}