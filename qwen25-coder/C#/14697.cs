public void MyMethod(string a, int b)\n{\n    if (a == null) throw new ArgumentNullException(nameof(a));\n\n    // No need to check 'b' for null as it's a non-nullable type.\n    \n    // more stuff here\n}