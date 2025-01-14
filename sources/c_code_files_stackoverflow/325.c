#include <stdio.h>
#include <string.h>

struct Customer {
    int id;
    char first_name[256];
    char last_name[256];
    struct {
        char street[256];
        char unit[256];
    } address;
    char state[2];
    int zip;
};