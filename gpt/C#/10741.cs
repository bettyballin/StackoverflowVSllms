GetData Buttons = new GetData(); // create a reference to the class\nTable builtTable = Buttons.BuildTable(); // Build the table\n\n// Add rows from the built table to the ButtonTable control\nforeach (TableRow row in builtTable.Rows)\n{\n    ButtonTable.Rows.Add(row);\n}\n\nOutPut.Text = ButtonTable.Rows.Count.ToString();