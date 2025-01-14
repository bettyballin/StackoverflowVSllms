#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *exec_and_get_output(const char* cmd) {
    FILE *fp;
    fp = popen(cmd, "r");
    if (fp == NULL) return NULL; // Error! exit and do something sensible.

    const size_t buffsize = 64000;
    char buffer[buffsize];
    memset(buffer, 0, sizeof(buffer));
    while (fgets(buffer, sizeof(buffer), fp) != NULL) { /* keep on reading until end of file. */ }

    char *ret_val = malloc(strlen(buffer)+1);
    strcpy(ret_val, buffer);
    pclose(fp); // make sure to close the pipe!
    return ret_val;
}

int main() {
    const size_t sz=64*1024/sizeof(char);
    char cmd[sz];
    snprintf(cmd, sz,"/usr/bin/php -q /var/www/html/phpinfo.php"); // beware of buffer overflow!
    printf("calling php function\n");
    char *res = exec_and_get_output(cmd);
    printf("%s", res?res:"No output...");
    free(res); // don't forget to clean up allocated memory.
    printf("\nEnd php function\n");
    return 0;
}