#include <iostream>\n   #include <vector>\n   #include <string>\n   #include <algorithm>\n\n   struct Production {\n       std::vector<int> inputSequence;\n       std::string outputToken;\n       int priority;\n   };\n\n   class TokenTransformer {\n   public:\n       TokenTransformer() {\n           // Define productions with priorities\n           productions = {\n               {{0, 1, 0, 1}, "Out3", 2},\n               {{0, 1}, "Out0", 1},\n               {{3, 4}, "Out1", 1},\n               // Add more productions as needed\n           };\n\n           // Sort productions based on priority (higher priority first)\n           std::sort(productions.begin(), productions.end(),\n                     [](const Production& a, const Production& b) {\n                         return a.priority > b.priority;\n                     });\n       }\n\n       std::string transform(const std::vector<int>& input) {\n           for (const auto& production : productions) {\n               if (std::search(input.begin(), input.end(),\n                               production.inputSequence.begin(),\n                               production.inputSequence.end()) != input.end()) {\n                   return production.outputToken;\n               }\n           }\n           return "No Output";\n       }\n\n   private:\n       std::vector<Production> productions;\n   };\n\n   int main() {\n       TokenTransformer transformer;\n       std::vector<int> input = {0, 1, 0, 1};\n       std::cout << transformer.transform(input) << std::endl; // Outputs "Out3"\n\n       return 0;\n   }