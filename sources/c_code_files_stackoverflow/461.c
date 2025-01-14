#include <libsmbclient.h>
#include <stdio.h>
#include <sys/stat.h>
#include <fcntl.h>

#define BUFLEN 1024

int main() {
    SMBCCTX *ctx;
    int fd;
    struct stat st;
    char buffer[BUFLEN];
    off_t offset;

    // Initialize the SMB context
    ctx = smbc_new_context();
    if (ctx == NULL) {
        perror("smbc_new_context");
        return 1;
    }

    // Set the SMB context
    if (smbc_set_context(ctx) != 0) {
        perror("smbc_set_context");
        smbc_free_context(ctx, 1);
        return 1;
    }

    // Open the file
    fd = smbc_open("smb://your_server/your_path", O_RDONLY, 0);
    if (fd == -1) {
        perror("smbc_open");
        smbc_free_context(ctx, 1);
        return 1;
    }

    // Get the file stats
    if (smbc_fstat(fd, &st) != 0) {
        perror("smbc_fstat");
        smbc_close(fd);
        smbc_free_context(ctx, 1);
        return 1;
    }

    // Read the file in chunks
    for (offset = st.st_size - BUFLEN; offset > 0; offset -= BUFLEN) {
        if (smbc_lseek(fd, offset, SEEK_SET) != offset) {
            perror("smbc_lseek");
            smbc_close(fd);
            smbc_free_context(ctx, 1);
            return 1;
        }

        ssize_t bytes_read = smbc_read(fd, buffer, BUFLEN);
        if (bytes_read != BUFLEN) {
            perror("smbc_read");
            smbc_close(fd);
            smbc_free_context(ctx, 1);
            return 1;
        }
    }

    // Clean up
    smbc_close(fd);
    smbc_free_context(ctx, 1);
    return 0;
}