std::string file_contents = std::string((std::istreambuf_iterator<char>(std::ifstream("file.txt"))), std::istreambuf_iterator<char>());