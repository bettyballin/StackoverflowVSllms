#include <iostream>\n#include <random>\n\nint main() {\n    std::random_device rd;\n    std::mt19937 gen(rd());\n    std::uniform_real_distribution<double> dis(0.0, 1.0);\n\n    double SubsRate = 0.003;\n    double nofRuns = 1000000;\n\n    int count = 0;\n    for (unsigned i = 0; i < nofRuns; i++) {\n        double randNum = dis(gen);\n        if (randNum < SubsRate) {\n            count++;\n            std::cout << "Sub" << std::endl;\n        }\n    }\n    std::cout << "Count: " << count << std::endl;\n    return 0;\n}