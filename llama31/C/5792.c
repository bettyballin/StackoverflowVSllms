#include <libudf/udf.h>\n\n// Initialize the UDF library\nudf_init();\n\n// Open the DVD device\nudf_device_t *device = udf_open_device("/dev/dvd");\n\n// Read the UDF filesystem\nudf_filesystem_t *fs = udf_read_filesystem(device);\n\n// Browse files on the disc\nudf_dir_t *root_dir = udf_get_root_dir(fs);\nudf_dir_entry_t *entry;\nwhile ((entry = udf_readdir(root_dir))) {\n    printf("%s\n", entry->name);\n}