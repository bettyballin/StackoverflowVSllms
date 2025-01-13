public ActionResult Index(int pageNumber = 1, int pageSize = 10)\n{\n    var query = @"\n        DECLARE @PageNumber INT = @PageNumber\n        DECLARE @PageSize INT = @PageSize\n\n        SELECT *\n        FROM (\n            SELECT *, ROW_NUMBER() OVER (ORDER BY Id) AS RowNum\n            FROM YourTable\n        ) AS PagedTable\n        WHERE RowNum BETWEEN (@PageNumber - 1) * @PageSize + 1 AND @PageNumber * @PageSize\n    ";\n\n    var parameters = new[]\n    {\n        new SqlParameter("@PageNumber", pageNumber),\n        new SqlParameter("@PageSize", pageSize)\n    };\n\n    var results = db.Database.SqlQuery<YourModel>(query, parameters).ToList();\n\n    return View(results);\n}