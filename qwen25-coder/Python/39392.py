def executeFunction(func as callable(int), value as int):\n       return func(value)\n\n   // Usage\n   myCallable = def(x as int) as int:\n       return x + 10\n\n   result = executeFunction(myCallable, 5)