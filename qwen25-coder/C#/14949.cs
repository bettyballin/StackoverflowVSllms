var result = (from n in News\n              group n by n.CategoryID into g\n              let topNewsInCategory = \n                  (from nc in g\n                   orderby nc.CreatedOn descending\n                   select nc)\n                   .FirstOrDefault()\n              where topNewsInCategory != null\n              select topNewsInCategory).ToList();