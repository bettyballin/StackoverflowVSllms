DataSet dataSet = new DataSet();\nDataTable empTable = new DataTable("Emp");\nempTable.Columns.Add("ID", typeof(int));\nempTable.Columns.Add("Name", typeof(string));\n\nDataTable ordTable = new DataTable("Ord");\nordTable.Columns.Add("EmpID", typeof(int));\nordTable.Columns.Add("Something", typeof(string));\nordTable.Columns.Add("Anotherthing", typeof(string));\n\ndataSet.Tables.Add(empTable);\ndataSet.Tables.Add(ordTable);\ndataSet.Relations.Add("Rel", empTable.Columns["ID"], ordTable.Columns["EmpID"]);