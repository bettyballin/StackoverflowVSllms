// C example: Execute command to put the computer into sleep mode\n#include <stdlib.h>\nint main() {\n    // Sleep mode using system call\n    system("sudo pm-suspend");\n\n    // Hibernate using system call\n    // system("sudo pm-hibernate");\n\n    // Shutdown using system call\n    // system("sudo shutdown -h now");\n}