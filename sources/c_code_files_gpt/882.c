#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function prototypes
char* append_id(char*);
char* increment_id(char*, int);
char* get_next_id(char*);

int main(void) {
    char *x;
    x = "zz";

    printf("Incrementing %s -> %s\n", x, get_next_id(x));

    return 0;
}

char* append_id(char *id) {
    int id_size = strlen(id);
    char* new_id = (char *) malloc((id_size + 2) * sizeof(char));

    if (new_id == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(1);
    }

    strcpy(new_id, id);
    strcat(new_id, "0");

    return new_id;
}

char* increment_id(char *id, int pos) {
    int id_size = strlen(id);
    char* new_id = (char *) malloc((id_size + 2) * sizeof(char));

    if (new_id == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(1);
    }

    strcpy(new_id, id);

    while(pos >= 0) {
        if(new_id[pos] == 'z') {
            new_id[pos] = 'a';
            if(pos == 0) {
                char* extended_id = (char *) malloc((id_size + 2) * sizeof(char));
                if (extended_id == NULL) {
                    fprintf(stderr, "Memory allocation failed\n");
                    exit(1);
                }
                strcpy(extended_id, "a");
                strcat(extended_id, new_id);
                free(new_id);
                return extended_id;
            }
            pos--;
        } else {
            new_id[pos]++;
            break;
        }
    }

    return new_id;
}

char* get_next_id(char *last_id) {
    int id_size = strlen(last_id);

    if (id_size == 0) {
        char* start_id = (char *) malloc(2 * sizeof(char));
        if (start_id == NULL) {
            fprintf(stderr, "Memory allocation failed\n");
            exit(1);
        }
        strcpy(start_id, "0");
        return start_id;
    }

    return increment_id(last_id, id_size - 1);
}