#include <iostream>\n  #include <string>\n  #include <limits>\n\n  int main() {\n      std::string line;\n      bool validInput = false;\n      int a;\n\n      do {\n          std::cout << "\nEnter a number: ";\n          std::getline(std::cin, line); // Read the entire line as string\n\n          try {\n              size_t pos;\n              a = std::stoi(line, &pos);  // Convert to integer\n              if (pos != line.size()) {    // Entire string should be digits\n                  throw std::invalid_argument("Non-numeric characters detected");\n              }\n              validInput = true;  // Valid input received\n          } catch (const std::exception& e) {\n              std::cout << "Invalid input: " << e.what() << ". Please enter a valid number." << std::endl;\n          }\n\n      } while (!validInput);\n\n      return 0;\n  }