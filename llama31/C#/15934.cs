string s = "abcdefghab";\nchar[] repeatedChars = s.GroupBy(c => c)\n                         .Where(g => g.Count() > 1)\n                         .Select(g => g.Key)\n                         .ToArray();