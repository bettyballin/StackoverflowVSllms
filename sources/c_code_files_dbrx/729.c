#include <windows.h>

int main() {
    LPCH pszCurrentVariable; // Pointer for current variable string in process's environment block;
#ifndef NO_ENVIRONMENT /* To avoid error if no Environment set */
    int nIndex; 
    LPCH szEnvVar = GetEnvironmentStrings();          // Retrieve the address of NULL-terminated array of strings that make up the local process’s current environment block.
    pszCurrentVariable= (LPCH)GetEnvironmentString(szEnvVar); // Assign string pointer to the first variable in the block and get its address;
#endif /* ! NO_ENVIRONMENT */
    return 0;
}