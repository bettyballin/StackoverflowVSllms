// Projection to memory and then using IsNullOrEmpty\n     var result = (from s in db.Strings select s).AsEnumerable()\n                  .Where(s => !string.IsNullOrEmpty(s))\n                  .ToList();