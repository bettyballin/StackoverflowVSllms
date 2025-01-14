#include <Python.h>

PyMODINIT_FUNC PyInit_modulename(void) {
    // Initialization code
    PyObject *m = PyModule_Create(&moduledef);
    if (m == NULL)
        return NULL;

    // Add module functions and variables here
    return m;
}

static struct PyModuleDef moduledef = {
    PyModuleDef_HEAD_INIT,
    "modulename",
    NULL,
    -1,
    NULL, NULL, NULL, NULL, NULL
};