#include <Python.h>

int main(int argc, char *argv[]) {
    Py_Initialize();
    PySys_SetArgv(argc, argv);  // This is necessary for PyRun_*() to work
    PyObject* sysPath = PySys_GetObject("path");  // Get sys.path object
    PyObject* dirObj = PyUnicode_DecodeFSDefault("/path/to/lib");   // Append your path here instead of "/path/to/lib"
    int result = PyList_Append(sysPath, dirObj);   // Do this for each additional directory that needs to be added.
    Py_DECREF(dirObj);
    // ... Import and run Python modules from the added paths
    Py_Finalize();
    return 0;
}