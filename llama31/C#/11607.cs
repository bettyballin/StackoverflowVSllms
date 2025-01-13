public static int GetHashCodeOfList(List<string> list)\n{\n    unchecked\n    {\n        int hash = 0;\n        foreach (var str in list)\n        {\n            hash ^= str.GetHashCode();\n        }\n        return hash;\n    }\n}