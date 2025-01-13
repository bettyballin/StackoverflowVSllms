char *strdup(const char *src) {\n    char *dst = malloc(strlen (src) + 1);  // Space for length plus nul\n    if (dst == NULL) return NULL;          // No memory\n    strcpy(dst, src);                      // Copy the characters\n    return dst;                            // Return the new string\n}