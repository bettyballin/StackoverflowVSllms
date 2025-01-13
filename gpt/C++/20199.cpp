#include <iostream>\n#include <sstream>\n#include <cstring>\n#include <cstdlib>\n#include <unistd.h>\n#include <sys/types.h>\n#include <sys/socket.h>\n#include <netinet/in.h>\n#include <netdb.h>\n\n#define BUFFER_SIZE 256\n\nint main() {\n    char buffer[BUFFER_SIZE];\n    std::stringstream readStream;\n    bool readData = true;\n    int socketFileDescriptor; // Assume this is initialized and connected properly\n\n    while (readData) {\n        std::cout << "Receiving chunk... ";\n\n        // Read a bit at a time, eventually "end" string will be received.\n        bzero(buffer, BUFFER_SIZE);\n        int readResult = read(socketFileDescriptor, buffer, BUFFER_SIZE - 1);\n        if (readResult < 0) {\n            perror("Could not read from socket");\n            close(socketFileDescriptor);\n            exit(EXIT_FAILURE);\n        }\n        \n        // Append the received data to the existing data.\n        readStream.write(buffer, readResult);\n\n        // Continue reading while "end;" is not found.\n        std::string receivedData = readStream.str();\n        readData = receivedData.find("end;") == std::string::npos;\n\n        std::cout << "Done (length: " << receivedData.length() << ")" << std::endl;\n    }\n\n    // Process the received data\n    std::string finalData = readStream.str();\n    std::cout << "Final received data: " << finalData << std::endl;\n\n    close(socketFileDescriptor);\n    return 0;\n}