#include <Python.h>

// Define the methods of your module here
static PyMethodDef module_methods[] = {
    // Example method definition
    // {"method_name", method_function, METH_VARARGS, "docstring"},
    {NULL, NULL, 0, NULL} // Sentinel value to indicate the end of the array
};

static struct PyModuleDef moduledef = {
    PyModuleDef_HEAD_INIT,
    "modulename",  /* name of module */
    NULL,          /* module documentation, may be NULL */
    -1,            /* size of per-interpreter state of the module,
                      or -1 if the module keeps state in global variables. */
    module_methods /* the PyMethodDef array from before */
};

// Module initialization function
PyMODINIT_FUNC PyInit_modulename(void) {
    return PyModule_Create(&moduledef);
}