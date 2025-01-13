protected void GridAccounts_RowDataBound(object sender, GridViewRowEventArgs e)\n{\n    if (e.Row.RowType == DataControlRowType.DataRow)\n    {\n        ImageButton deleteButton = (ImageButton)e.Row.Cells[0].Controls[0];\n        // Assuming there's a way to get the name of the row item, adjust this line accordingly\n        string itemName = "ItemName"; // Replace with actual data binding logic if needed\n        // Corrected OnClientClick assignment\n        deleteButton.OnClientClick = $"return confirm('Are you sure you want to delete payment method {itemName.Replace("'", @"\'")}?');";\n    }\n}