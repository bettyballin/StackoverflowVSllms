public int LevenshteinDistance(string s, string t)\n   {\n       int[,] d = new int[s.Length + 1, t.Length + 1];\n       for (int i = 0; i <= s.Length; i++)\n           d[i, 0] = i;\n       for (int j = 0; j <= t.Length; j++)\n           d[0, j] = j;\n       for (int i = 1; i <= s.Length; i++)\n       {\n           for (int j = 1; j <= t.Length; j++)\n           {\n               int cost = (s[i - 1] == t[j - 1]) ? 0 : 1;\n               d[i, j] = Math.Min(\n                   Math.Min(d[i - 1, j] + 1, d[i, j - 1] + 1),\n                   d[i - 1, j - 1] + cost);\n           }\n       }\n       return d[s.Length, t.Length];\n   }