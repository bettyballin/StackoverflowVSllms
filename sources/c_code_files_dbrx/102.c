#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

char* append_id(const char *id) {
    size_t id_len = strlen(id);

    if (id[id_len - 1] == 'z') { // edge case for 'zz' => 'zza', etc.
        id_len++;
    }

    char* new_id = malloc((id_len + 2) * sizeof(char)); // Allocate one extra byte for terminating '\0'.
    if (!new_id){
      fprintf(stderr, "Memory allocation failed!\n");
      exit(-1); // End the program with an error code.
    }
    memcpy(new_id + 1, id, id_len * sizeof(*new_id)); // copy old string to new one

    if (new_id[id_len - 1] == 'z') { // edge case for 'zz' => 'zza', etc.
        new_id[0] = 'a';
    } else {
        new_id[id_len] = '\0'; // add null terminator if needed.
        char lastLetter = (char)tolower(new_id[id_len - 1]);
        if (lastLetter < 'z') {
            ++lastLetter;
            new_id[id_len] = new_id[0]; // Save the first character to be moved in a moment.
            new_id[id_len - 1] = lastLetter; // Write back the incremented char.
        } else {     // We reached 'z', append instead of incrementing.
            memmove(new_id+2,new_id+1,(strlen(new_id)-1)*sizeof(*new_id)); // Making room for an extra character by moving characters down by 1 position.
            new_id[0] = 'a';
        }
    }

    return new_id;
}

int main() {
    char* id = "test";
    char* new_id = append_id(id);
    printf("%s\n", new_id);
    free(new_id);
    return 0;
}