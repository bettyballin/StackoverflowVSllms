var query = context.log_sales\n    .GroupBy(c => new \n    { \n        Year = c.OrderTime.Year, \n        Month = c.OrderTime.Month \n    })\n    .Select(g => new\n    {\n        Location1 = g.Where(c => c.Location == "Location1").Sum(c => c.Charge) ?? 0,\n        Location2 = g.Where(c => c.Location == "Location2").Sum(c => c.Charge) ?? 0,\n        Location3 = g.Where(c => c.Location == "Location3").Sum(c => c.Charge) ?? 0,\n        Date = new DateTime(g.Key.Year, g.Key.Month, 1)\n    })\n    .OrderByDescending(x => x.Date)\n    .ToList();