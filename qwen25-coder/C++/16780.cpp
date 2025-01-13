#include <iostream>\n#include <fstream>\n#include <dirent.h>\n#include <string>\n\nvoid listProcesses() {\n    DIR *dir;\n    struct dirent *entry;\n\n    // Open the /proc directory which contains process information\n    if ((dir = opendir("/proc")) == NULL) {\n        perror("opendir");\n        return;\n    }\n\n    while ((entry = readdir(dir)) != NULL) {\n        // Check if entry is numeric (which indicates a process ID)\n        if (isdigit(entry->d_name[0])) {\n            std::string pid = entry->d_name;\n            std::ifstream statusFile("/proc/" + pid + "/status");\n            std::string line;\n\n            // Read the status file to get information about the process\n            while (getline(statusFile, line)) {\n                if (line.compare(0, 6, "Name:") == 0) {\n                    std::cout << "PID: " << pid << " - " << line << std::endl;\n                }\n            }\n\n            statusFile.close();\n        }\n    }\n\n    closedir(dir);\n}\n\nint main() {\n    listProcesses();\n    return 0;\n}