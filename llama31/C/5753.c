#define PRINT_PARAM(format, ...) \\n    printf(format, __VA_ARGS__); \\n    fprintf(file_p, format, __VA_ARGS__)\n\n// ...\n\nPRINT_PARAM("Starting serial number       [%ld]\n", serial_info_p->start_int_idx);\nPRINT_PARAM("Current Serial number         [%d]\n", serial_info_p->current_int_idx);