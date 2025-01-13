// Assume we have a dictionary that maps control IDs to database fields\nDictionary<string, string> columnMappings = new Dictionary<string, string>\n{\n    { "txtName", "Users.Name" },\n    { "ddlStatus", "Users.Status" }\n    // Add more mappings as needed\n};\n\nprotected void SearchButton_Click(object sender, EventArgs e)\n{\n    List<SqlParameter> parameters = new List<SqlParameter>();\n    StringBuilder queryBuilder = new StringBuilder("SELECT * FROM Users WHERE 1 = 1");\n\n    foreach (var control in this.Controls)\n    {\n        if (control is TextBox textBox && !string.IsNullOrEmpty(textBox.Text))\n        {\n            if (columnMappings.TryGetValue(textBox.ID, out string columnName))\n            {\n                queryBuilder.Append($" AND {columnName} = @{columnName.Replace('.', '_')}");\n                parameters.Add(new SqlParameter($"@{columnName.Replace('.', '_')}", textBox.Text));\n            }\n        }\n        else if (control is DropDownList dropDownList && dropDownList.SelectedIndex > 0)\n        {\n            if (columnMappings.TryGetValue(dropDownList.ID, out string columnName))\n            {\n                queryBuilder.Append($" AND {columnName} = @{columnName.Replace('.', '_')}");\n                parameters.Add(new SqlParameter($"@{columnName.Replace('.', '_')}", dropDownList.SelectedValue));\n            }\n        }\n    }\n\n    string query = queryBuilder.ToString();\n    // Execute the query using the parameters\n    ExecuteQuery(query, parameters.ToArray());\n}\n\nprivate void ExecuteQuery(string query, SqlParameter[] parameters)\n{\n    using (SqlConnection connection = new SqlConnection("YourConnectionStringHere"))\n    {\n        using (SqlCommand command = new SqlCommand(query, connection))\n        {\n            command.Parameters.AddRange(parameters);\n            connection.Open();\n            using (SqlDataReader reader = command.ExecuteReader())\n            {\n                // Process the results\n            }\n        }\n    }\n}