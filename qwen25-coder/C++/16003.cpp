#include <windows.h>\n#include <iostream>\n#include <thread>\n#include <iomanip>\n#include <sstream>\n\nvoid updateConsole(int percentComplete, int bufferSize) {\n    // Get handle to stdout console\n    HANDLE hStdout = GetStdHandle(STD_OUTPUT_HANDLE);\n\n    // Set cursor position to the beginning of the line where you want to update\n    COORD cursorPosition;\n    cursorPosition.X = 0;  // Start at the beginning of the line.\n    cursorPosition.Y = 0;  // Change 'Y' value as per your requirement if you are updating multiple lines\n\n    SetConsoleCursorPosition(hStdout, cursorPosition);\n\n    // Prepare the string\n    std::ostringstream oss;\n    oss << "Running... " << std::setw(2) << std::setfill('0') << percentComplete << "% complete\r";\n    oss << "Buffer size:  " << std::setw(4) << bufferSize << " bytes\n";\n\n    // Write the string to console\n    DWORD charsWritten;\n    std::string output = oss.str();\n    WriteConsoleA(hStdout, output.c_str(), static_cast<DWORD>(output.length()), &charsWritten, NULL);\n}\n\nint main() {\n    int percentComplete = 0;\n    int bufferSize = 1024;\n\n    while (percentComplete <= 100) {\n        updateConsole(percentComplete, bufferSize);\n\n        // Simulate work being done\n        std::this_thread::sleep_for(std::chrono::milliseconds(500));\n\n        // Increment progress values for demonstration\n        percentComplete += 5;\n        bufferSize += 256;\n    }\n\n    return 0;\n}