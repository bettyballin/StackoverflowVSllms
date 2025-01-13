using (var dbContext = new MyDbContext())\n{\n    var searchTerm = "searchTerm";\n    var results = dbContext.Database.SqlQuery<MyTable>("SELECT * FROM myTable WHERE CONTAINS(myColumn, @searchTerm)", new SqlParameter("@searchTerm", searchTerm));\n    // process the results\n}