void print_param(FILE* fp, const char* format, ...) {\n    va_list args;\n    va_start(args, format);\n    vfprintf(fp, format, args);\n    va_end(args);\n}\n\n// ...\n\n// Print to screen\nprint_param(stdout, "Starting serial number       [%ld]\n", serial_info_p->start_int_idx);\nprint_param(stdout, "Current Serial number         [%d]\n", serial_info_p->current_int_idx);\n\n// Print to file\nprint_param(file_p, "Starting serial number       [%ld]\n", serial_info_p->start_int_idx);\nprint_param(file_p, "Current Serial number         [%d]\n", serial_info_p->current_int_idx);