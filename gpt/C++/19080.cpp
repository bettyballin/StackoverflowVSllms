#include <iostream>\n#include <string>\n#include <cassert>\n\n#define ASSERT(expr) \\n    if (!(expr)) { \\n        std::cerr << "Assertion failed in function " << __FUNCTION__ << " at " << __FILE__ << ":" << __LINE__ << "\n" \\n                  << "Expression: " << #expr << "\n"; \\n        abort(); \\n    }\n\nint CMainFrame::OnCreate(LPCREATESTRUCT lpCreateStruct)\n{\n   ASSERT(lpCreateStruct->cx > 0);\n   // Other code...\n   return 0;\n}\n\nint main() {\n    // Example usage\n    CMainFrame frame;\n    LPCREATESTRUCT lpCreateStruct = { /* Initialization */ };\n    frame.OnCreate(lpCreateStruct);\n}