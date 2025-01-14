#include <dlfcn.h>
#include <stdio.h>
#include <stdlib.h>

void *handle;
double (*cosine)(double);
char *error;

int main(int argc, char **argv) {
    handle = dlopen ("/lib/libmysharedlibrary.so", RTLD_LAZY);
    if (!handle) {
        fprintf (stderr, "%s\n", dlerror());
        exit(1);
    }

    cosine = dlsym(handle, "say_hello");
    if ((error = dlerror()) != NULL)  {
        fprintf (stderr, "%s\n", error);
        exit(1);
    }

    (*cosine)(2.0); /* invoke function */
    dlclose(handle);
    return 0;
}