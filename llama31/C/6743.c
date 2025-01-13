// Python's file object struct\ntypedef struct {\n    PyObject_HEAD\n    int fd;  // file descriptor\n} PyFileObject;\n\n// Finalizer function for PyFileObject\nstatic void file_dealloc(PyFileObject *f) {\n    close(f->fd);\n    Py_TYPE(f)->tp_free((PyObject *)f);\n}