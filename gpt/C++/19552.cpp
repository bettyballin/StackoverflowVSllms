#include <iostream>\n#include <fstream>\n#include <vector>\n\nvoid xorEncryptDecrypt(std::vector<char>& data, const std::string& key) {\n    for (size_t i = 0; i < data.size(); ++i) {\n        data[i] ^= key[i % key.length()];\n    }\n}\n\nint main() {\n    std::string key = "mysecretkey";  // Example key\n    std::vector<char> data = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};  // Example data\n\n    // Encrypt the data\n    xorEncryptDecrypt(data, key);\n    std::cout << "Encrypted data: ";\n    for (char c : data) {\n        std::cout << std::hex << (int)c << ' ';\n    }\n    std::cout << std::endl;\n\n    // Decrypt the data\n    xorEncryptDecrypt(data, key);\n    std::cout << "Decrypted data: ";\n    for (char c : data) {\n        std::cout << c;\n    }\n    std::cout << std::endl;\n\n    return 0;\n}