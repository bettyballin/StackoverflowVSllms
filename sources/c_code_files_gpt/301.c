#include <stdio.h>
#include <string.h>

int lorem_ipsum_length(const char *text) {
    printf("Processing text: %s\n", text);
    return strlen(text);
}

int main() {
    const char *words[] = { "Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit" };
    size_t num_words = sizeof(words) / sizeof(words[0]);

    for (size_t i = 0; i < num_words; i++) {
        int length = lorem_ipsum_length(words[i]);
        printf("Length of '%s': %d\n", words[i], length);
    }

    return 0;
}