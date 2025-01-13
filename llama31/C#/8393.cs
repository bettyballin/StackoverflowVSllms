DataTable dt = dataset.Tables["A"];\n\n// Create a DataView with only the desired columns\nDataView dv = new DataView(dt);\ndv.Table = new DataTable();\ndv.Table.Columns.Add("a3", typeof(string));\ndv.Table.Columns.Add("a4", typeof(string));\n\n// Copy the data from the original DataTable to the DataView\nforeach (DataRow row in dt.Rows)\n{\n    dv.AddNew();\n    dv["a3"] = row["a3"];\n    dv["a4"] = row["a4"];\n    dv.EndEdit();\n}\n\n// Bind the DataView to your DataGrid\ndataGrid.DataSource = dv;\ndataGrid.DataBind();