List<char> chars = new List<char>();\n    chars.AddRange(Enumerable.Range(0x0000, 9).Select(i => (char)i));\n    chars.AddRange(Enumerable.Range(0x000B, 2).Select(i => (char)i));