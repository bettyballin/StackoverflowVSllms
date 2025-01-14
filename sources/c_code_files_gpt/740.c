#include <Python.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    // Set the PYTHONHOME environment variable to indicate where Python's standard library is located
    setenv("PYTHONHOME", "/path/to/custom/pythonhome", 1);

    // Set the PYTHONPATH environment variable to include the directories where your modules are located
    setenv("PYTHONPATH", "/path/to/custom/pythonpath", 1);

    // Initialize the Python interpreter
    Py_Initialize();

    // Optionally, you can further customize the sys.path if needed
    PyRun_SimpleString("import sys");
    PyRun_SimpleString("sys.path.append('/additional/custom/path')");

    // Your embedding code here

    // Finalize the Python interpreter
    Py_Finalize();

    return 0;
}