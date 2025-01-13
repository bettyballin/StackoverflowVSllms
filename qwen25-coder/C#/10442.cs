protected void RefreshGridView()\n{\n    // Assume you have a method or property to get the original data structure\n    var dataTable = GetOriginalDataSource(); // Should return the DataTable\n\n    // Create a new DataTable with the same schema\n    DataTable dt = dataTable.Clone();\n\n    // Iterate through GridView rows and populate the new DataTable\n    foreach (GridViewRow row in GridView1.Rows)\n    {\n        DataRow newRow = dt.NewRow();\n        for (int i = 0; i < row.Cells.Count; i++)\n        {\n            string dataField = dataTable.Columns[i].ColumnName;\n            Label label = (Label)row.FindControl($"lbl{GetControlSuffix(dataField)}");\n            if (label != null)\n            {\n                newRow[dataField] = label.Text;\n            }\n        }\n        dt.Rows.Add(newRow);\n    }\n\n    // Replace the old DataTable with the new one\n    GridView1.DataSource = dt;\n    GridView1.DataBind();\n}\n\nprivate string GetControlSuffix(string fieldName)\n{\n    // Map column names to control IDs as defined in your GridView TemplateField\n    switch (fieldName.ToLower())\n    {\n        case "code":\n            return "Code";\n        case "title":\n            return "Title";\n        // Add more mappings as necessary\n        default:\n            throw new ArgumentException("Unknown field name");\n    }\n}