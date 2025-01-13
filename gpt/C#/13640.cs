// Step 1: Create a DataTable containing distinct parentIDs from myOtherTable\nDataTable distinctParentIDs = myDS.myOtherTable.DefaultView.ToTable(true, "parentID");\n\n// Step 2: Filter myTable based on the distinct parentIDs\nstring filterExpression = string.Join(",", distinctParentIDs.AsEnumerable().Select(row => row["parentID"].ToString()).ToArray());\nDataRow[] filteredRows = myDS.myTable.Select("id IN (" + filterExpression + ")");\n\n// Step 3: Create a DataTable from the filtered rows\nDataTable filteredTable = myDS.myTable.Clone(); // Clone to get the same schema\nforeach (DataRow row in filteredRows)\n{\n    filteredTable.ImportRow(row);\n}\n\n// Step 4: Create a DataView based on the filtered DataTable\nDataView dv = new DataView(filteredTable, "", "name asc", DataViewRowState.CurrentRows);