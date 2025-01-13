#include <iostream>\n#include <signal.h>\n#include <sys/socket.h> // For socket operations\n#include <netinet/in.h> // For sockaddr_in\n#include <unistd.h>     // for close()\n\nint mySocket = -1; // Global to keep track of the socket\n\n// Signal handler function\nvoid signalHandler(int signum) {\n    std::cout << "Interrupt signal (" << signum << ") received.\n";\n    \n    if (mySocket != -1) {\n        close(mySocket);\n        mySocket = -1;\n    }\n    \n    exit(signum); \n}\n\nint main() {\n    // Register signal and signal handler\n    signal(SIGINT, signalHandler);  // Handle Ctrl+C\n    signal(SIGTERM, signalHandler); // Handle kill command\n    \n    // Create socket (example)\n    mySocket = socket(AF_INET, SOCK_STREAM, 0);\n    if (mySocket == -1) {\n        std::cerr << "Could not create socket\n";\n        return -1;\n    }\n    \n    // Bind, listen and accept connections here...\n    \n    while (true) {\n        // Server loop\n    }\n\n    return 0;\n}