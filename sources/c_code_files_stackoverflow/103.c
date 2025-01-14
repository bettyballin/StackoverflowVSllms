#include <stdio.h>

// Define the structure for a token bucket filter
typedef struct {
    int tokens; // Current number of tokens in the bucket
} TokenBucketFilter;

// Function to check if there are enough tokens in the bucket for a given number of bytes
// Returns 0 on success, -1 if not enough tokens are available
int check_tokens(TokenBucketFilter *tbf, int bytes) {
    if (bytes <= tbf->tokens) {
        tbf->tokens -= bytes;
        return 0; // Success
    } else {
        return -1; // Not enough tokens
    }
}

int main() {
    // Example usage
    TokenBucketFilter tbf;
    tbf.tokens = 100; // Initialize with 100 tokens
    
    int bytes = 50; // Number of bytes to check for
    int result = check_tokens(&tbf, bytes);
    
    if (result == 0) {
        printf("Enough tokens available. Remaining tokens: %d\n", tbf.tokens);
    } else {
        printf("Not enough tokens available.\n");
    }
    
    return 0;
}