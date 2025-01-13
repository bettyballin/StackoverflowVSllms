amespace {\nvoid doProcessA(std::vector<int>& data, int dataMember) {\n    // ...\n}\n\nvoid doProcessB(std::vector<int>& data, int otherDataMember) {\n    // ...\n}\n}\n\nclass MyUsefulClass {\npublic:\n    std::vector<int> processUsefulData(std::vector<int>& data);\nprivate:\n    int dataMember_;\n    int otherDataMember_;\n};\n\nstd::vector<int> MyUsefulClass::processUsefulData(std::vector<int>& data) {\n    doProcessA(data, dataMember_);\n    doProcessB(data, otherDataMember_);\n    return data;\n}