#include <stdio.h>\n#include <dirent.h>\n\nint main() {\n    DIR *dir;\n    struct dirent *entry;\n\n    // Open the directory\n    dir = opendir(".");\n    if (dir == NULL) {\n        perror("opendir");\n        return 1;\n    }\n\n    // Read the directory entries\n    while ((entry = readdir(dir)) != NULL) {\n        printf("%s\n", entry->d_name);\n    }\n\n    // Close the directory\n    closedir(dir);\n    return 0;\n}