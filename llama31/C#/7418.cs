DataSet ds = new DataSet();\nds.Tables.Add(new DataTable());\nds.Tables[0].Columns.Add("column_1", typeof(string));\nds.Tables[0].Columns.Add("column_2", typeof(int));\nds.Tables[0].Columns.Add("column_4", typeof(string));\n\n// Insert column "column_3" after "column_2"\nint columnIndex = ds.Tables[0].Columns.IndexOf("column_2");\nds.Tables[0].Columns.Add("column_3", typeof(string));\nds.Tables[0].Columns["column_3"].SetOrdinal(columnIndex + 1);