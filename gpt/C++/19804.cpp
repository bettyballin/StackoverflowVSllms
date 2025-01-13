#include <iostream>\n#include <sys/types.h>\n#include <sys/socket.h>\n#include <netinet/in.h>\n#include <unistd.h>\n#include <cstring>\n\nclass Server {\npublic:\n    Server(int port);\n    ~Server();\n    void run();\n\nprivate:\n    int mySocket;\n    struct sockaddr_in serverAddr;\n};\n\nServer::Server(int port) {\n    mySocket = socket(AF_INET, SOCK_STREAM, 0);\n    if (mySocket < 0) {\n        std::cerr << "Error opening socket!" << std::endl;\n        exit(1);\n    }\n\n    int opt = 1;\n    if (setsockopt(mySocket, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt)) < 0) {\n        std::cerr << "Error setting socket options!" << std::endl;\n        close(mySocket);\n        exit(1);\n    }\n\n    std::memset(&serverAddr, 0, sizeof(serverAddr));\n    serverAddr.sin_family = AF_INET;\n    serverAddr.sin_addr.s_addr = INADDR_ANY;\n    serverAddr.sin_port = htons(port);\n\n    if (bind(mySocket, (struct sockaddr *)&serverAddr, sizeof(serverAddr)) < 0) {\n        std::cerr << "Error on binding!" << std::endl;\n        close(mySocket);\n        exit(1);\n    }\n}\n\nServer::~Server() {\n    close(mySocket);\n}\n\nvoid Server::run() {\n    listen(mySocket, 5);\n    std::cout << "Server running..." << std::endl;\n    // Server loop to accept connections\n    // ...\n}\n\nint main() {\n    Server server(8080);\n    server.run();\n    return 0;\n}