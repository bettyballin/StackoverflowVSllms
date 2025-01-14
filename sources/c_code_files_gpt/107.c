#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define CHUNK_SIZE 4096

void computeLPSArray(char* pattern, int M, int* lps) {
    int length = 0;
    int i = 1;
    lps[0] = 0;

    while (i < M) {
        if (pattern[i] == pattern[length]) {
            length++;
            lps[i] = length;
            i++;
        } else {
            if (length != 0) {
                length = lps[length - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
}

void KMPSearch(char* pattern, char* text, int* lps, int chunk_offset) {
    int M = strlen(pattern);
    int N = strlen(text);

    int i = 0;
    int j = 0;
    while (i < N) {
        if (pattern[j] == text[i]) {
            j++;
            i++;
        }
        if (j == M) {
            printf("Found pattern at index %d\n", i - j + chunk_offset);
            j = lps[j - 1];
        } else if (i < N && pattern[j] != text[i]) {
            if (j != 0)
                j = lps[j - 1];
            else
                i++;
        }
    }
}

void searchInFile(const char* filename, const char* pattern) {
    FILE* file = fopen(filename, "rb");
    if (file == NULL) {
        perror("Failed to open file");
        return;
    }

    int M = strlen(pattern);
    int* lps = (int*) malloc(M * sizeof(int));
    computeLPSArray(pattern, M, lps);

    char* buffer = (char*) malloc(CHUNK_SIZE + M - 1);
    if (buffer == NULL) {
        perror("Failed to allocate buffer");
        fclose(file);
        free(lps);
        return;
    }

    size_t bytesRead;
    size_t chunk_offset = 0;
    while ((bytesRead = fread(buffer + M - 1, 1, CHUNK_SIZE, file)) > 0) {
        buffer[bytesRead + M - 1] = '\0';
        KMPSearch(pattern, buffer, lps, chunk_offset);

        chunk_offset += bytesRead;

        // Move the last M-1 characters to the beginning of the buffer
        memmove(buffer, buffer + CHUNK_SIZE, M - 1);
    }

    free(buffer);
    free(lps);
    fclose(file);
}

int main() {
    const char* filename = "largefile.txt";
    const char* pattern = "your_pattern";
    
    searchInFile(filename, pattern);
    
    return 0;
}