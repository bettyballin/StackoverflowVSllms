#include <Python.h>

int add(int a, int b) {
    return a + b;
}

static PyMethodDef myextension_methods[] = {
    {NULL, NULL, 0, NULL}
};

static struct PyModuleDef myextensionmodule = {
    PyModuleDef_HEAD_INIT,
    "myextension",
    NULL,
    -1,
    myextension_methods
};

PyMODINIT_FUNC PyInit_myextension(void) {
    return PyModule_Create(&myextensionmodule);
}