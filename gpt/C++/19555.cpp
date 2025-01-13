#include <boost/filesystem.hpp>\n#include <iostream>\n\nnamespace fs = boost::filesystem;\n\nint main() {\n    fs::path directory_path("path/to/your/directory");\n\n    if (fs::exists(directory_path) && fs::is_directory(directory_path)) {\n        for (const auto& entry : fs::directory_iterator(directory_path)) {\n            std::cout << entry.path().string() << std::endl;\n        }\n    } else {\n        std::cerr << "Directory does not exist or is not a directory." << std::endl;\n    }\n\n    return 0;\n}