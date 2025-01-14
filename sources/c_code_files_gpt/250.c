#include <Python.h>

void init_python() {
    Py_Initialize();
    PyEval_InitThreads();
    // Other initialization code
}

int main() {
    init_python();
    
    // Example of executing a Python string
    PyRun_SimpleString("print('Hello from Python!')");
    
    Py_Finalize();
    return 0;
}