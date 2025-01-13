import inspect\n\ndef example_function(arg1, arg2, kwarg1=None):\n    pass\n\n# Get the signature of the function\nsignature = inspect.signature(example_function)\n\n# Extract the parameters from the signature\nparameters = signature.parameters\n\n# Get a list of argument names\nargument_names = [param.name for param in parameters.values()]\n\nprint(argument_names)