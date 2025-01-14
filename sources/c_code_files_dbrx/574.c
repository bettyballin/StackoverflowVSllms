#define FUSE_USE_VERSION 26
#include <fuse.h>
#include <stdio.h>
#include <string.h>
#include <limits.h>

static const char *hello_str = "Hello World!\n";

static void hello_read(const char *path, char *buf, size_t bufsize) {
    memset(buf, '\0', bufsize);
    strncpy(buf, hello_str, MIN(strlen(hello_str), bufsize));
}

static int hello_readdir(const char *path, void *buf, fuse_fill_dir_t filler, off_t offset, struct fuse_file_info *fi) {
    // Simple readdir implementation that only returns the file "hello"
    filler(buf, "hello", NULL, 0);
    return 0;
}

static int hello_open(const char *path, struct fuse_file_info *fi) {
    // Simple open implementation that always succeeds
    return 0;
}

static struct fuse_operations hello_oper = {
    .readdir = hello_readdir,
    .open = hello_open,
    .read = hello_read,
};

int main(int argc, char *argv[]) {
    return fuse_main(argc, argv, &hello_oper, NULL);
}