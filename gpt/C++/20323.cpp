#include <memory>\n\nstd::unique_ptr<int> ptr(new int);\n// Use ptr\nptr.reset();  // Automatically deletes and sets to NULL