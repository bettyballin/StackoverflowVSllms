// test.c\n\n// This will not generate a warning\nint global_var;\n\n// This will generate a warning\nstatic int static_global_var;\n\nvoid func() {\n    // This will generate a warning\n    int local_var;\n}