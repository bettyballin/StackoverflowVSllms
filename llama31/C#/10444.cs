public Dictionary<char, int> GetCharacterFrequencies(string input)\n{\n    var charCount = new Dictionary<char, int>();\n    foreach (char c in input)\n    {\n        if (charCount.ContainsKey(c))\n        {\n            charCount[c]++;\n        }\n        else\n        {\n            charCount[c] = 1;\n        }\n    }\n    return charCount;\n}