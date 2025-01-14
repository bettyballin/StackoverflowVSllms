#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

char* increment_id(const char *id, size_t pos) {
    // 'a' in ASCII is 97. Decreasing it by 1 makes any single digit to be converted into a character between 'b' and 'z'.
    const int alphaBeginIdx = (int)'a' - 1;

    char *new_id;
    size_t id_len = strlen(id);

    int lastIncrementedChar = (int)(tolower(id[pos])); // getting the position of letter at provided index 'i'
    if (isdigit((unsigned char)lastIncrementedChar)){
        new_id = strdup(id);
        if(!new_id){
            fprintf(stderr, "Memory allocation failed!\n");
            exit(-1); // End the program with an error code.
        }
        ++lastIncrementedChar; // increment the ascii position of existing number or character (digit) at index [pos]
    } else if(!isalpha((unsigned char)id[pos])){
        fprintf(stderr, "Input to function incorrect!\n");
        exit(-1);//End program execution.
    } else { // If the input was not a number & is a character then increment it.
        lastIncrementedChar = ((int)'z' == lastIncrementedChar) ? alphaBeginIdx : (lastIncrementedChar - alphaBeginIdx + 1) % 26;
    }
    new_id[pos] = 'a' + lastIncrementedChar ; // Converting the number back to its associated character.
    for(int i = pos + 1; i < strlen(new_id); ++i){   // For all digits coming after that, set them as zero if last incremented char was a alphabetical otherwise leave it untouched
        new_id[i] = ((unsigned char)id[lastIncrementedChar-'a'] != (int)'z') & isdigit((unsigned char)id[i]) ? '0' : new_id[i]; // incrementing last position.
    }
    return new_id; //return the updated array of characters(string).
}