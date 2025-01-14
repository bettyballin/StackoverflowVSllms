#include <stdio.h>
#include <stdlib.h>

int main() {
    char command[] = "ls -la;/path/to_some_script.sh";  // Semi-colon (;) usage
    system(command);
    return 0;
}