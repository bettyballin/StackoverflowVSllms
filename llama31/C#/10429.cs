static string GetColumnName(int index)\n{\n    const int alphabetsCount = 26;\n    if (index > alphabetsCount)\n    {\n        int mod = index % alphabetsCount;\n        int columnIndex = index / alphabetsCount;\n        if (mod == 0)\n        {\n            columnIndex -= 1;\n            mod = alphabetsCount;\n        }\n        return GetColumnName(columnIndex) + GetColumnName(mod);\n    }\n    else\n    {\n        return ((char)('A' + index - 1)).ToString();\n    }\n}