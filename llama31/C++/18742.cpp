std::string symbolNameStr(symbolName);\nif (theMap.find(symbolNameStr) == theMap.end()) {\n    TheObject theObject(symbolNameStr);\n    theMap.insert(std::make_pair(symbolNameStr, theObject));\n}