#include <iostream>\n#include <termios.h>\n#include <unistd.h>\n\nchar getch() {\n    char buf = 0;\n    struct termios old = {0};\n    if (tcgetattr(0, &old) < 0)\n        perror("tcsetattr()");\n    old.c_lflag &= ~ICANON;\n    old.c_lflag &= ~ECHO;\n    old.c_cc[VMIN] = 1;\n    old.c_cc[VTIME] = 0;\n    if (tcsetattr(0, TCSANOW, &old) < 0)\n        perror("tcsetattr ICANON");\n    if (read(0, &buf, 1) < 0)\n        perror("read()");\n    old.c_lflag |= ICANON;\n    old.c_lflag |= ECHO;\n    if (tcsetattr(0, TCSADRAIN, &old) < 0)\n        perror("tcsetattr ~ICANON");\n    return buf;\n}\n\nint main() {\n    std::cout << "Press any key to continue...\n";\n    char ch = getch();  // Get a single character without waiting for ENTER\n    std::cout << "You pressed: " << ch << std::endl;\n    return 0;\n}