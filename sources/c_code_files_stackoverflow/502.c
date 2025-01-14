#include <Python.h>
#include <stdio.h>

int main() {
    printf("%zu\n", PY_SSIZE_T_MAX / sizeof(PyObject*));
    return 0;
}