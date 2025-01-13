// Example of Boost.Thread usage: Creating Threads\n#include <boost/thread.hpp>\n\nvoid threadFunction(int id) {\n    std::cout << "Thread ID: " << id << std::endl;\n}\n\nint main() {\n    boost::thread threads[4];\n    for (int i = 0; i < 4; ++i) {\n        threads[i] = boost::thread(threadFunction, i);\n    }\n    for (auto& th : threads) {\n        th.join();\n    }\n}