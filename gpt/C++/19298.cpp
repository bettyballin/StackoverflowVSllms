#include <boost/asio.hpp>\n#include <fstream>\n#include <iostream>\n#include <vector>\n\nint main() {\n    using namespace boost::asio;\n    io_service ios;\n    ip::tcp::socket socket(ios);\n    ip::tcp::resolver resolver(ios);\n    connect(socket, resolver.resolve({"localhost", "daytime"}));\n\n    std::ifstream file("file.txt", std::ios::binary);\n    if (!file) {\n        std::cerr << "Unable to open file." << std::endl;\n        return 1;\n    }\n\n    std::vector<char> buffer((std::istreambuf_iterator<char>(file)), std::istreambuf_iterator<char>());\n    boost::system::error_code ec;\n    write(socket, buffer_cast<const_buffers_1>(buffer.data()), ec);\n\n    if (ec) {\n        std::cerr << "Error writing to socket: " << ec.message() << std::endl;\n        return 1;\n    }\n\n    return 0;\n}