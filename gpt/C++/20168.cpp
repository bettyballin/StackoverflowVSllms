#include <iostream>\n#include <limits>\n\nusing namespace std;\n\nint main() {\n    int a;\n    bool validInput = false;\n\n    do {\n        cout << "\nEnter a number: ";\n        cin >> a;\n\n        if (cin.fail()) {\n            // Clear the fail state\n            cin.clear();\n            // Ignore the rest of the invalid input\n            cin.ignore(numeric_limits<streamsize>::max(), '\n');\n            cout << "Invalid input. Please enter a valid number." << endl;\n        } else {\n            // Clear the input buffer to handle cases like "1asdsdf"\n            cin.ignore(numeric_limits<streamsize>::max(), '\n');\n            validInput = true;\n        }\n    } while (!validInput);\n\n    cout << "You entered: " << a << endl;\n\n    return 0;\n}