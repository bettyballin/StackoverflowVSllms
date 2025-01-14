#include <Python.h>
#include <structmember.h>

static PyObject* example(PyObject* self, PyObject* args) {
    const char* command;
    if (!PyArg_ParseTuple(args, "s", &command))
        return NULL;
    return Py_BuildValue("s", command);
}

static PyMethodDef ExampleMethods[] = {
    {"example", example, METH_VARARGS, "Execute a command."},
    {NULL, NULL, 0, NULL}
};

PyMODINIT_FUNC PyInit_example(void) {
    static struct PyModuleDef examplemodule = {
        PyModuleDef_HEAD_INIT,
        "example",
        NULL,
        -1,
        ExampleMethods
    };
    return PyModule_Create(&examplemodule);
}