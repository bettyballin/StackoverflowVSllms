#include <sys/stat.h>\n#include <fcntl.h>\n\n// ...\n\nint fd = open(fileName, O_CREAT | O_RDWR, 0777);\nif (fd != -1) {\n    // To ensure the permissions are set correctly, use fchmod\n    fchmod(fd, 0777);\n}