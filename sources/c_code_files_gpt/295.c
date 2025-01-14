#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include "iso9660.h"

// Define the SECTOR_SIZE constant
#define SECTOR_SIZE 2048

// Your custom function to read a sector
int read_sector(uint32_t sector, uint8_t* buffer) {
    // Implement your raw read from DVD here
    // Return the number of bytes read, or a negative error code
    return SECTOR_SIZE; // Replace with actual implementation
}

// Custom function to replace libiso9660's read
static int my_read_block(uint8_t* buf, uint32_t lsn, uint32_t nblocks, void* user_data) {
    for (uint32_t i = 0; i < nblocks; ++i) {
        if (read_sector(lsn + i, buf + (i * SECTOR_SIZE)) < 0) {
            return -1; // Error reading sector
        }
    }
    return nblocks * SECTOR_SIZE;
}

int main() {
    iso9660_t* iso = iso9660_open_custom(my_read_block, NULL);
    if (!iso) {
        // Handle error
        return -1;
    }

    // Read and traverse the filesystem
    iso9660_stat_t* root = iso9660_ifs_stat_root(iso);
    if (root) {
        // Process root directory
        iso9660_dir_t* dir = iso9660_ifs_readdir(iso, root);
        while (dir) {
            // Process directory entries
            printf("File: %s\n", dir->filename);
            dir = iso9660_ifs_readdir_next(iso, root);
        }
    }

    // Cleanup
    iso9660_close(iso);
    return 0;
}