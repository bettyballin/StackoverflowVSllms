List<List<UInt32>> temp = new List<List<UInt32>>();\nint temps = 0;\nint i = 0;\n\nwhile (i < temp.Count)\n{\n    if (temp[i].Count == 1)\n    {\n        temp.RemoveAt(i);\n        temps++;\n    }\n    else\n    {\n        i++;\n    }\n}