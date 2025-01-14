#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ini.h"

typedef struct {
    const char* name;
    int value;
} configuration;

static int handler(void* user, const char* section, const char* name,
                   const char* value) {
    configuration* pconfig = (configuration*)user;

    if (strcmp(name, "some_setting") == 0) {
        pconfig->value = atoi(value);
    }

    return 1;
}

int main() {
    configuration config;
    config.name = "some_setting"; // Initialize the name field
    config.value = 0; // Initialize the value field
    if (ini_parse("example.ini", handler, &config) < 0) {
        printf("Can't load 'example.ini'\n");
        return 1;
    }

    printf("some_setting: %d\n", config.value);
    return 0;
}