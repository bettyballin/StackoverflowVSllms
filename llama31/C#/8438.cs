var query = dbContext.MyTable.Where(x => x.IsActive);\nvar count = query.Count(); // generates a SQL COUNT() query