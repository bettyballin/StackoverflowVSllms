private string getElement(DataRow row, string columnName)\n{\n    return row.Field<string>(columnName);\n}