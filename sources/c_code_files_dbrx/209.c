#include <blake2.h>
#include <string.h>
#include <stdio.h>

// Define a function to calculate the minimum of two values
size_t minLength(size_t a, size_t b) {
    return (a < b) ? a : b;
}

// Generate product key given ID and SECRET_KEY (server side)
void genProductKey(uint8_t *key, const char *id) {
    // Allocate BLAKE2 hash output buffer
    uint8_t out[BLAKE2S_OUTBYTES];
    // Concatenate ID and SECRET_KEY in an array
    size_t idLen = strlen(id);
    const char *secKey = "SomeSecretKeyOnlyKnownToYou"; // Replace with your secret key!
    uint8_t data[BLAKE2S_BLOCKBYTES] = {0}; // Pad SECRET_KEY with zero bytes if necessary (e.g., via memset)
    memcpy(data, id, minLength(idLen, sizeof(data) - 1));
    memcpy(data + minLength(idLen, sizeof(data) - 1), secKey, BLAKE2S_BLOCKBYTES - minLength(idLen + strlen(secKey), BLAKE2S_BLOCKBYTES));
    // Generate hash using BLAKE2
    blake2s(out, data, sizeof(data) - 1);
    // Convert the hash into human-readable format by decoding each 5 bytes as base64: 'aaaaa-bbbbb-ccccc-ddddd-eeeee' <=> out[0]...out[24]
    // ... (omitted base64 conversion for brevity)
}

// Verify product key license (client side)
int verifyProductKey(uint8_t *key, const char *id) {
    // Allocate BLAKE2 hash output buffer
    uint8_t expected[BLAKE2S_OUTBYTES];
    // Derive SECRET_KEY (not stored in the app for security reasons. Just included here for demonstration purposes!)
    const char *secKey = "SomeSecretKeyOnlyKnownToYou";
    // Generate hash using BLAKE2
    blake2s(expected, id, strlen(id) + strlen(secKey), secKey);
    // Compare expected hash with the key passed by the user. For simplicity, assume proper decoding of human-readable 'aaaaa...' base64 format into hash bytes (out[0]...out[24]).
    for (size_t i = 0; i < BLAKE2S_OUTBYTES; ++i) { 
        if (key[i] != expected[i]) {
            return -1; // Returns negative number if differences found (invalid license)
        }
    }
    return 0; // Returns zero if no differences found (valid license)
}

int main() {
    uint8_t key[BLAKE2S_OUTBYTES];
    const char *id = "example_id";
    genProductKey(key, id);
    int result = verifyProductKey(key, id);
    printf("Verification result: %d\n", result);
    return 0;
}