// mymodule.c\nstatic void internal_function(void) {\n    // sensitive operations here\n}\n\nvoid public_function(void) {\n    internal_function();\n}