var result = context.YourEntities\n    .Include(e => e.RelatedEntities1)\n    .Include(e => e.RelatedEntities2)\n    .AsSplitQuery()\n    .ToList();