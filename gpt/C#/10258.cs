void Try<TException>(Action action)\n{\n  try\n  {\n    action();\n  }\n  catch (TException) { }\n}\n\nvoid Main()\n{\n  Try<ExceptionC>(() => Try<ExceptionB>(() => Try<ExceptionA>(foo)));\n}