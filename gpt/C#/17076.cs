@Html.Grid(Model).Columns(columns =>\n   {\n       columns.Add(c => c.PropertyName).Titled("Header");\n       // Add more columns as needed\n   })