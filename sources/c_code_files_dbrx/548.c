#include <errno.h>
#define _FILE_OFFSET_BITS 64
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <fuse.h>

static const char* hello_str = "Hello World!\n";
static const char *file_name = "myFuseFile";

static int myFuseLogic(const char *path, struct stat *stbuf) {
    if (strcmp(path + 1, file_name) == 0) {
        stbuf->st_mode = S_IFREG | 0444;
        stbuf->st_nlink = 1;
        stbuf->st_size = strlen(hello_str);
        return 0;
    }
    return -ENOENT; // No such file or dir error
}

static int myFuseLogic2(const char *path, char *buf, size_t size, off_t offset, struct fuse_file_info *fi) {
    if (strcmp(path + 1, file_name) == 0 && buf != NULL) {
        strncpy(buf, hello_str, size);
        return strlen(hello_str);
    }
    return -ENOENT; // No such file or dir error
}

static const struct fuse_operations myFuseOps = {
    .getattr  = myFuseLogic, 
    .read = myFuseLogic2,
    .open = NULL,
    .release = NULL
};

int main(int argc, char* argv[]) {
    return fuse_main(argc, argv, &myFuseOps, NULL); // Run the FUSE filesystem
}