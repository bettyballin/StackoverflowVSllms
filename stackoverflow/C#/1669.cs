var result = new DataContext().Table.AsEnumerable()\n                     .Select((x, i) => new { Index = i, Item = x })\n                     .Where(t => t.Index % 5 == 0).Select(t => t.Item);