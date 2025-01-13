var result = News\n    .GroupBy(n => n.CategoryID)\n    .Select(g => g.OrderByDescending(nc => nc.CreatedOn).FirstOrDefault())\n    .Where(news => news != null)\n    .ToList();