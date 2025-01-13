std::string line;\nstd::map<std::string, std::string> props;\nstd::ifstream file("foo.txt");\nwhile(std::getline(file, line)) {\n    std::string token;\n    std::istringstream tokens(line);\n    while(tokens >> token) {\n        std::size_t pos = token.find('=');\n        if(pos != std::string::npos) {\n            props[token.substr(0, pos)] = token.substr(pos + 1);\n        }\n    }\n\n    /* work with those keys/values by doing properties["name"] */\n    Line l(props["pc"], props["ct"], ...);\n\n    /* clear the map for the next line */\n    props.clear();\n}