#include <dirent.h>\n\n...\n\nint file_count = 0;\nDIR * dirp;\nstruct dirent * entry;\n\ndirp = opendir("path"); /* There should be error handling after this */\nwhile ((entry = readdir(dirp)) != NULL) {\n    if (entry->d_type == DT_REG) { /* If the entry is a regular file */\n         file_count++;\n    }\n}\nclosedir(dirp);