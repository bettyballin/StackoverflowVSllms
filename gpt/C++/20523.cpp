#include <iostream>\n#include <string>\n\nclass Command {\npublic:\n    Command(const std::string& cmd) : command(cmd) {}\n    \n    Command* Exec() {\n        // Simulate command execution\n        std::cout << "Executing: " << command << std::endl;\n        result = "Execution Result";\n        return this;\n    }\n\n    std::string GetResults() {\n        return result;\n    }\n\nprivate:\n    std::string command;\n    std::string result;\n};\n\n#define MakeCommand(cmd) new Command(cmd)\n#define DSL(...) MakeCommand(#__VA_ARGS__)->Exec()->GetResults()\n\nint main() {\n    std::string results = DSL(for p in people do something);\n    std::cout << "Results: " << results << std::endl;\n    return 0;\n}