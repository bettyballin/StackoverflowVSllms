// utils.cpp\n#pragma once\n#include "stdafx.h"\n#pragma comment(lib, "winhttp.lib") // Add this line\n\nclass http\n{\npublic:\n    http();\n    ~http();\n\n    std::string getText();\n};