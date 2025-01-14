#include <stdio.h>
#include <stdlib.h>

int main() {
    char command[] = "ls && /path/to_some_script.sh";  // And (&&) operator usage
    system(command);
    return 0;
}