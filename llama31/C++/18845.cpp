#include <iostream>\n#include <fstream>\n\nint main() {\n    struct student {\n        int rollNo;\n    };\n\n    struct student stud1;\n    stud1.rollNo = 1;\n\n    std::ofstream fout("stu1.dat", std::ios::binary);\n    fout.write(reinterpret_cast<char*>(&stud1), sizeof(stud1));\n    fout.close();\n\n    std::ifstream filin("stu1.dat", std::ios::binary);\n    struct student tmpStu;\n    while (filin.read(reinterpret_cast<char*>(&tmpStu), sizeof(tmpStu))) {\n        std::cout << tmpStu.rollNo << std::endl;\n    }\n    filin.close();\n\n    return 0;\n}