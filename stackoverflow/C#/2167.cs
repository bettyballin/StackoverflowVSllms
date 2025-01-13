public int Hash(T a, int s)\n{\n    // e.g.\n    return Random( a.Name().ToInt() + s ).NextDouble();\n}\n\npublic int Compare(T x, T y, int s)\n{\n    if (x.Equals(y)) return 0;\n\n    int result = _comparer(x, y);\n\n    if (result != 0) return result;\n\n    return (Hash(x, s) < Hash(y, s) ) ? -1 : 1;\n}