#include <stdlib.h>

int main() {
    char command[] = "command1 && command2; command3 || command4";
    system(command);
    return 0;
}