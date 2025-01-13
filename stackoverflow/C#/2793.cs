public bool TryEnter(object lockObject, Action work) \n{\n    if (Monitor.TryEnter(lockObject)) \n    {\n       try \n       {\n          work();\n       }\n       finally \n       {\n           Monitor.Exit(lockObject);\n       }        \n       return true;\n     }\n\n     return false;\n}