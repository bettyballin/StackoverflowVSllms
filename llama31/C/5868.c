#include <stdint.h>\n#include <stdlib.h>\n\n// LCG parameters\n#define A 1664525\n#define B 1013904223\n#define M 4294967296 // 2^32\n\n// Bloom filter parameters\n#define K 7 // number of hash functions\n#define M_BLOOM 1048576 // 2^20 (about 1MB)\n\n// Structure to store LCG state and Bloom filter\ntypedef struct {\n    uint32_t x; // current LCG state\n    uint32_t n; // current number of songs\n    uint8_t* bloom_filter; // Bloom filter bit array\n} celestial_jukebox_t;\n\n// Initialize the Celestial Jukebox\nvoid celestial_jukebox_init(celestial_jukebox_t* jukebox, uint32_t seed, uint32_t initial_n) {\n    jukebox->x = seed;\n    jukebox->n = initial_n;\n    jukebox->bloom_filter = malloc(M_BLOOM / 8);\n    memset(jukebox->bloom_filter, 0, M_BLOOM / 8);\n}\n\n// Generate the next song index\nuint32_t celestial_jukebox_next(celestial_jukebox_t* jukebox) {\n    // Update LCG state\n    jukebox->x = (A * jukebox->x + B) % M;\n\n    // Map LCG state to song index\n    uint32_t song_index = jukebox->x % jukebox->n;\n\n    // Check if song has already been played (Bloom filter)\n    for (int i = 0; i < K; i++) {\n        uint32_t hash = song_index + i * 2654435761;\n        if (jukebox->bloom_filter[hash % M_BLOOM / 8] & (1 << (hash % 8))) {\n            // Song has already been played, try again\n            return celestial_jukebox_next(jukebox);\n        }\n    }\n\n    // Mark song as played (Bloom filter)\n    for (int i = 0; i < K; i++) {\n        uint32_t hash = song_index + i * 2654435761;\n        jukebox->bloom_filter[hash % M_BLOOM / 8] |= 1 << (hash % 8);\n    }\n\n    return song_index;\n}\n\n// Add new songs to the jukebox\nvoid celestial_jukebox_add_songs(celestial_jukebox_t* jukebox, uint32_t new_n) {\n    jukebox->n = new_n;\n    // Update LCG state\n    jukebox->x = (A * (jukebox->x + jukebox->n) + B) % (new_n + 1);\n}