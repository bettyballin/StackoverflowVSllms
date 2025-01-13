#include <vector>\n#include <string>\n#include <algorithm>\n\n// ...\n\nstd::vector<std::string> files = {"file1.txt", "file2.txt", "file3.txt", ...};\n\n// Perform search and remove files that don't match parameters\nfiles.erase(std::remove_if(files.begin(), files.end(),\n    [](const std::string& file) { /* return true if file doesn't match parameters */ }),\n    files.end());