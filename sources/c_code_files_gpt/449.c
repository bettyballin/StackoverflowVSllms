#include <glib.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h> // for tolower and ispunct

void count_words(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (!file) {
        perror("Failed to open file");
        return;
    }

    GHashTable *hash_table = g_hash_table_new(g_str_hash, g_str_equal);
    char word[256];

    while (fscanf(file, "%255s", word) != EOF) {
        // Normalize the word: convert to lowercase (optional)
        for (char *p = word; *p; ++p) *p = tolower(*p);

        // Remove punctuation from the word (optional, simple example)
        char *end = word + strlen(word) - 1;
        while (end > word && ispunct((unsigned char)*end)) *end-- = '\0';

        gpointer value = g_hash_table_lookup(hash_table, word);
        if (value) {
            g_hash_table_insert(hash_table, g_strdup(word), GINT_TO_POINTER(GPOINTER_TO_INT(value) + 1));
        } else {
            g_hash_table_insert(hash_table, g_strdup(word), GINT_TO_POINTER(1));
        }
    }

    fclose(file);

    // Print the results
    GHashTableIter iter;
    gpointer key, value;
    g_hash_table_iter_init(&iter, hash_table);
    while (g_hash_table_iter_next(&iter, &key, &value)) {
        printf("%s: %d\n", (char *)key, GPOINTER_TO_INT(value));
    }

    // Cleanup
    g_hash_table_destroy(hash_table);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <filename>\n", argv[0]);
        return EXIT_FAILURE;
    }

    count_words(argv[1]);
    return EXIT_SUCCESS;
}