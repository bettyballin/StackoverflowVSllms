#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <unistd.h>\n#include <sys/stat.h>\n\n#define MAX_PATH 1024\n\nint check_secure_directory(const char *path) {\n    struct stat st;\n    if (stat(path, &st) != 0) {\n        perror("Failed to get file status");\n        return -1;\n    }\n\n    // Check owner and group\n    uid_t trusted_uids[] = {0, 1, 2}; // root, bin, sys\n    gid_t trusted_gids[] = {0, 1, 2}; // root, bin, sys\n\n    int is_owner_trusted = 0;\n    for (size_t i = 0; i < sizeof(trusted_uids)/sizeof(*trusted_uids); ++i) {\n        if (st.st_uid == trusted_uids[i]) {\n            is_owner_trusted = 1;\n            break;\n        }\n    }\n\n    int is_group_trusted = 0;\n    for (size_t i = 0; i < sizeof(trusted_gids)/sizeof(*trusted_gids); ++i) {\n        if (st.st_gid == trusted_gids[i]) {\n            is_group_trusted = 1;\n            break;\n        }\n    }\n\n    if (!is_owner_trusted) {\n        fprintf(stderr, "Directory owner not trusted\n");\n        return -1;\n    }\n\n    // Check permissions\n    if (!(st.st_mode & S_IWOTH)) {\n        if (st.st_mode & S_IWGRP && !is_group_trusted) {\n            fprintf(stderr, "Group has write privileges but is not trusted\n");\n            return -1;\n        }\n    } else {\n        fprintf(stderr, "Others have write permissions\n");\n        return -1;\n    }\n\n    printf("Directory %s is secure\n", path);\n    return 0;\n}\n\nint main() {\n    const char *pqr_home = getenv("PQR_HOME");\n    if (!pqr_home) {\n        fprintf(stderr, "Environment variable PQR_HOME not set\n");\n        exit(EXIT_FAILURE);\n    }\n\n    char resolved_path[MAX_PATH];\n    if (realpath(pqr_home, resolved_path) == NULL) {\n        perror("Failed to resolve path");\n        exit(EXIT_FAILURE);\n    }\n\n    printf("Resolved path: %s\n", resolved_path);\n\n    // Check each directory in the resolved path\n    char *token;\n    char temp_path[MAX_PATH];\n    strcpy(temp_path, resolved_path);\n\n    token = strtok(temp_path, "/");\n    const char *current_dir = "/";\n    while (token) {\n        static char dir_to_check[MAX_PATH];\n        snprintf(dir_to_check, sizeof(dir_to_check), "%s%s", current_dir, token);\n        if (check_secure_directory(dir_to_check) != 0) {\n            fprintf(stderr, "Failed security check on directory: %s\n", dir_to_check);\n            exit(EXIT_FAILURE);\n        }\n        // Update the current directory path\n        snprintf(current_dir, sizeof(current_dir), "%s%s/", current_dir, token);\n        token = strtok(NULL, "/");\n    }\n\n    printf("All directories are secure; proceeding with program.\n");\n\n    return 0;\n}