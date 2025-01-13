import inspect\n\ndef get_current_module_name():\n    frame = inspect.stack()[1]\n    module_name = inspect.getmodule(frame[0]).__name__\n    return module_name\n\ndef get_current_class_name():\n    frame = inspect.stack()[1]\n    class_name = frame[0].f_locals["self"].__class__.__name__\n    return class_name