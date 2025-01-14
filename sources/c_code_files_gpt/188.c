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

static struct PyModuleDef examplemodule = {
    PyModuleDef_HEAD_INIT,
    "example",
    NULL,
    -1,
    ExampleMethods
};

PyMODINIT_FUNC PyInit_example(void) {
    return PyModule_Create(&examplemodule);
}

int main() {
    Py_Initialize();
    PyObject* m = PyInit_example();
    if (m == NULL) {
        PyErr_Print();
        return 1;
    }
    Py_DECREF(m);
    Py_Finalize();
    return 0;
}