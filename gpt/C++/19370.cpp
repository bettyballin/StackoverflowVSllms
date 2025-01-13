#include <iostream>\n#include <cstdlib>\n#include <ctime>\n\nusing namespace std;\n\nint main() {\n    // Initialize Random Seed \n    srand(time(NULL));\n\n    double SubsRate = 0.003;  \n    double nofRuns = 1000000;\n    int count = 0;\n\n    for (unsigned i = 0; i < nofRuns; i++) {\n        double randomValue = static_cast<double>(rand()) / RAND_MAX;\n\n        if (randomValue < SubsRate) {\n            cout << "3 Sub" << endl;\n            count++;\n        }\n    }\n\n    // Output the total number of times "3 Sub" was printed\n    cout << "Total '3 Sub' occurrences: " << count << endl;\n\n    return 0;\n}