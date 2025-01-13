#include <iostream>\n#include <vector>\n#include <algorithm>\n#include <random>\n#include <ctime>\n\nclass CritGenerator {\npublic:\n    CritGenerator(float critChance, int bufferSize) : critChance(critChance), bufferSize(bufferSize) {\n        generateBuffer();\n    }\n\n    bool getNextHit() {\n        if (currentIndex >= buffer.size()) {\n            generateBuffer();\n        }\n        return buffer[currentIndex++];\n    }\n\nprivate:\n    float critChance;\n    int bufferSize;\n    int currentIndex = 0;\n    std::vector<bool> buffer;\n\n    void generateBuffer() {\n        buffer.clear();\n        int numCrits = static_cast<int>(critChance * bufferSize);\n        int numNormals = bufferSize - numCrits;\n\n        buffer.insert(buffer.end(), numCrits, true);\n        buffer.insert(buffer.end(), numNormals, false);\n\n        // Shuffle the buffer to randomize the distribution\n        std::random_device rd;\n        std::mt19937 g(rd());\n        std::shuffle(buffer.begin(), buffer.end(), g);\n\n        currentIndex = 0;\n    }\n};\n\nint main() {\n    const float critChance = 0.20f;\n    const int bufferSize = 10;\n    CritGenerator critGen(critChance, bufferSize);\n\n    // Simulate 30 hits\n    for (int i = 0; i < 30; ++i) {\n        std::cout << "Hit " << (i + 1) << ": " << (critGen.getNextHit() ? "Critical" : "Normal") << std::endl;\n    }\n\n    return 0;\n}