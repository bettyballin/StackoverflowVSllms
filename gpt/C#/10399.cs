public int GetMaxLength(string columnName)\n   {\n       var metadata = /* Fetch your metadata list from where you stored it */;\n       var column = metadata.FirstOrDefault(c => c.ColumnName == columnName);\n       return column != null ? column.MaxLength : 0; // Default to 0 if not found\n   }