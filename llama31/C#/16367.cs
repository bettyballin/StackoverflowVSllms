if (ds.Tables["table1"].Rows.Count == 0)\n{\n    throw new ApplicationException("Data not found for identifier " + identifier);\n}