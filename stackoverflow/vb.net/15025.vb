Public Function MyFunction(ByVal ParamArray p as String())\n   ' p is a normal array in here\nEnd Function\n\n' This is a valid call\nMyFunction(New String() {"a", "b", "c", "d"})\n\n' So is this\nMyFunction("a", "b", "c", "d")