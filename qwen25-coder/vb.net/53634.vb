Dim result = _context.Contacts _\n    .Where(Function(c) Not String.IsNullOrEmpty(c.FullName)) _\n    .GroupBy(Function(c) c.FullName.ToUpper().Substring(0, 1)) _\n    .Select(Function(g) New With {\n        .FirstLetter = g.Key,\n        .Count = g.Count()\n    }) _\n    .OrderBy(Function(x) x.FirstLetter) _\n    .ToList()