try\n   {\n       // Code that might throw the exception\n   }\n   catch (Exception ex)\n   {\n       log.Error("An error occurred in MyExceptionHelperClass constructor", ex);\n       throw;\n   }