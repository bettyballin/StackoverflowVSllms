var records = dbContext.Table.SqlQuery("SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNum, * FROM Table) AS T WHERE RowNum % 5 = 1").ToList();