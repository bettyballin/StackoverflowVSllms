public DataTable GetImproperRecords(DataTable ProperRecords, DataTable ImproperRecords) {\n  DataTable relatedTable = new DataTable("Difference");\n  try {\n     using (DataSet dataSet = new DataSet()) {\n        dataSet.Tables.AddRange(new DataTable[] { ProperRecords.Copy(), ImproperRecords.Copy() });\n\n        DataColumn properColumn = new DataColumn();\n        properColumn = dataSet.Tables[0].Columns[1]; // Assuming subsNumber is at index 1\n\n        DataColumn improperColumn = new DataColumn();\n        improperColumn = dataSet.Tables[1].Columns[0]; // Assuming subsNumber is at index 0\n\n        //Create DataRelation\n        DataRelation relation = new DataRelation(string.Empty, properColumn, improperColumn, false);\n\n        dataSet.Relations.Add(relation);\n\n        //Create columns for return relatedTable\n        for (int i = 0; i < ImproperRecords.Columns.Count; i++) {\n           relatedTable.Columns.Add(ImproperRecords.Columns[i].ColumnName, ImproperRecords.Columns[i].DataType);\n        }\n\n        relatedTable.BeginLoadData();\n\n        foreach (DataRow parentrow in dataSet.Tables[1].Rows) {\n           DataRow[] childrows = parentrow.GetChildRows(relation);\n\n           if (childrows != null && childrows.Length > 0)\n              relatedTable.LoadDataRow(parentrow.ItemArray, true);\n\n        }\n\n        relatedTable.EndLoadData();\n\n     }\n  }\n  catch (Exception ex) {\n     Console.WriteLine(ex.Message);\n  }\n\n  return relatedTable;\n}