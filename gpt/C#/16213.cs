string s = getElement(tr, elementName);\n\nprivate string getElement(DataRow tr, string elementName)\n{\n    return tr.Table.Columns.Cast<DataColumn>()\n                           .Where(c => c.ColumnName == elementName)\n                           .Select(c => tr[c].ToString())\n                           .FirstOrDefault();\n}